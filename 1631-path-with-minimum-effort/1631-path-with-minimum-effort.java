class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0, 0});

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int e = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == m - 1 && c == n - 1)
                return e;

            if (e > effort[r][c])
                continue;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int edge =
                        Math.abs(heights[r][c] - heights[nr][nc]);

                int newEffort = Math.max(e, edge);

                if (newEffort < effort[nr][nc]) {

                    effort[nr][nc] = newEffort;

                    pq.offer(new int[]{
                            newEffort,
                            nr,
                            nc
                    });
                }
            }
        }

        return 0;
    }
}