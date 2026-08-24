class Solution {

    public int minimumTime(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

      
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dist = new long[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][0] = 0;

        pq.offer(new long[]{0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long time = cur[0];
            int r = (int) cur[1];
            int c = (int) cur[2];

            if (time != dist[r][c]) {
                continue;
            }

            if (r == m - 1 && c == n - 1) {
                return (int) time;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                long nextTime = time + 1;

                if (nextTime >= grid[nr][nc]) {

                  
                    nextTime = time + 1;

                } else {

                    long waitTime = grid[nr][nc];

                    
                    if ((waitTime - (time + 1)) % 2 != 0) {
                        waitTime++;
                    }

                    nextTime = waitTime;
                }

                if (nextTime < dist[nr][nc]) {

                    dist[nr][nc] = nextTime;

                    pq.offer(new long[]{
                        nextTime,
                        nr,
                        nc
                    });
                }
            }
        }

        return -1;
    }
}