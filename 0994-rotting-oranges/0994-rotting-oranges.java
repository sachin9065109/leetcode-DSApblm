class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        int fresh = 0;

      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int time = 0;

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];
            int t = current[2];

            time = Math.max(time, t);

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (grid[nr][nc] == 1) {

                    grid[nr][nc] = 2;

                    fresh--;

                    q.offer(new int[]{nr, nc, t + 1});
                }
            }
        }

        if (fresh > 0) {
            return -1;
        }

        return time;
    }
}