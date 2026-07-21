class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long minTime = Integer.MAX_VALUE;

        for (int t : workerTimes) {
            minTime = Math.min(minTime, t);
        }

        long high = minTime * 1L * mountainHeight * (mountainHeight + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canReduce(workerTimes, mountainHeight, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(int[] workerTimes, int mountainHeight, long time) {
        long total = 0;

        for (int t : workerTimes) {
            long left = 0;
            long right = mountainHeight;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long cost = t * mid * (mid + 1) / 2;

                if (cost <= time) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            total += right;

            if (total >= mountainHeight) {
                return true;
            }
        }

        return false;
    }
}