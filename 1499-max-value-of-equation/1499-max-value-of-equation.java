class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        long ans = Long.MIN_VALUE;

        for (int j = 0; j < points.length; j++) {
            int xj = points[j][0];
            int yj = points[j][1];

            while (!dq.isEmpty() && xj - points[dq.peekFirst()][0] > k) {
                dq.pollFirst();
            }

            if (!dq.isEmpty()) {
                int i = dq.peekFirst();

                long value = (long) points[i][1] - points[i][0]
                        + points[j][1] + points[j][0];

                ans = Math.max(ans, value);
            }

            long current = (long) yj - xj;

            while (!dq.isEmpty()) {
                int last = dq.peekLast();

                long lastValue = (long) points[last][1] - points[last][0];

                if (lastValue <= current) {
                    dq.pollLast();
                } else {
                    break;
                }
            }

            dq.offerLast(j);
        }

        return (int) ans;
    }
}