class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long minTime = 1;
        long minBus = time[0];

        for (int t : time) {
            minBus = Math.min(minBus, t);
        }

        long maxTime = minBus * (long) totalTrips;

        while (minTime < maxTime) {
            long mid = minTime + (maxTime - minTime) / 2;

            long trips = 0;

            for (int t : time) {
                trips += mid / t;

                if (trips >= totalTrips) {
                    break;
                }
            }

            if (trips >= totalTrips) {
                maxTime = mid;
            } else {
                minTime = mid + 1;
            }
        }

        return minTime;
    }
}