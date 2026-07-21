class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long minRank = Integer.MAX_VALUE;

        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }

        long high = minRank * 1L * cars * cars;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canRepair(ranks, cars, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        long repaired = 0;

        for (int rank : ranks) {
            repaired += (long) Math.sqrt((double) time / rank);

            if (repaired >= cars) {
                return true;
            }
        }

        return false;
    }
}