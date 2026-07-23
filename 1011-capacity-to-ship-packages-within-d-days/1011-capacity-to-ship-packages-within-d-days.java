class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int requiredDays = 1;
        int currentWeight = 0;

        for (int w : weights) {

            if (currentWeight + w > capacity) {
                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += w;
        }

        return requiredDays <= days;
    }
}