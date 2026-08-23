class Solution {

    public int[][] colorGrid(int n, int m, int[][] sources) {

        int[][] grid = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[3], a[3]);
            }
        );

        for (int[] source : sources) {

            int r = source[0];
            int c = source[1];
            int color = source[2];

            grid[r][c] = color;
            dist[r][c] = 0;

            pq.offer(new int[]{0, r, c, color});
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int d = current[0];
            int r = current[1];
            int c = current[2];
            int color = current[3];

            if (d != dist[r][c] || color != grid[r][c]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int newDist = d + 1;

                if (newDist < dist[nr][nc]) {

                    dist[nr][nc] = newDist;
                    grid[nr][nc] = color;

                    pq.offer(new int[]{
                        newDist, nr, nc, color
                    });
                }

                else if (newDist == dist[nr][nc]
                         && color > grid[nr][nc]) {

                    grid[nr][nc] = color;

                    pq.offer(new int[]{
                        newDist, nr, nc, color
                    });
                }
            }
        }

        return grid;
    }
}