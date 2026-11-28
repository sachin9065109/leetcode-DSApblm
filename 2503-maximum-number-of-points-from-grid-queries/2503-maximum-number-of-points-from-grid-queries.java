class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;

        int k = queries.length;
        int[][] qs = new int[k][2];

        for (int i = 0; i < k; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }

        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[k];
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int points = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int[] query : qs) {
            int limit = query[0];

            while (!pq.isEmpty() && pq.peek()[0] < limit) {
                int[] cur = pq.poll();

                int r = cur[1];
                int c = cur[2];

                points++;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        !visited[nr][nc]) {

                        visited[nr][nc] = true;
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }

            ans[query[1]] = points;
        }

        return ans;
    }
}