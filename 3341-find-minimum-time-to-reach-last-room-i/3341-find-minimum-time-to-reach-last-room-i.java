class Solution {

    public int minTimeToReach(int[][] moveTime) {

        int n = moveTime.length;
        int m = moveTime[0].length;

        long INF = Long.MAX_VALUE / 4;

        long[][] dist = new long[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        // {time, row, column}
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

            // Outdated state
            if (time != dist[r][c]) {
                continue;
            }

            // Destination
            if (r == n - 1 && c == m - 1) {
                return (int) time;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                // Wait until the next room opens,
                // then spend exactly 1 second to enter it.
                long newTime =
                    Math.max(time, (long) moveTime[nr][nc]) + 1;

                if (newTime < dist[nr][nc]) {

                    dist[nr][nc] = newTime;

                    pq.offer(new long[]{
                        newTime,
                        nr,
                        nc
                    });
                }
            }
        }

        return -1;
    }
}