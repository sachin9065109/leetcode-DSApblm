class Solution {

    public int minTimeToReach(int[][] moveTime) {

        int n = moveTime.length;
        int m = moveTime[0].length;

        long INF = Long.MAX_VALUE / 4;

        long[][][] dist = new long[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j][0] = INF;
                dist[i][j][1] = INF;
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][0][0] = 0;

        pq.offer(new long[]{0, 0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long time = cur[0];
            int r = (int) cur[1];
            int c = (int) cur[2];
            int parity = (int) cur[3];

            if (time != dist[r][c][parity]) {
                continue;
            }

            if (r == n - 1 && c == m - 1) {
                return (int) time;
            }

         
            int moveCost = (parity == 0) ? 1 : 2;

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

             
                long startTime = Math.max(
                    time,
                    (long) moveTime[nr][nc]
                );

                long newTime = startTime + moveCost;

              
                int nextParity = 1 - parity;

                if (newTime < dist[nr][nc][nextParity]) {

                    dist[nr][nc][nextParity] = newTime;

                    pq.offer(new long[]{
                        newTime,
                        nr,
                        nc,
                        nextParity
                    });
                }
            }
        }

        return -1;
    }
}