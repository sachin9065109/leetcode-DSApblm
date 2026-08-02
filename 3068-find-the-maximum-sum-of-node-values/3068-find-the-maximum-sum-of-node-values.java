class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        long sum = 0;
        int positiveCount = 0;

        int minPositiveGain = Integer.MAX_VALUE;
        int maxNegativeGain = Integer.MIN_VALUE;

        for (int num : nums) {

            int changed = num ^ k;
            int gain = changed - num;

            if (gain > 0) {
                sum += changed;
                positiveCount++;
                minPositiveGain = Math.min(minPositiveGain, gain);
            } else {
                sum += num;
                maxNegativeGain = Math.max(maxNegativeGain, gain);
            }
        }

        if ((positiveCount & 1) == 0) {
            return sum;
        }

        long option1 = sum - minPositiveGain;

        long option2 = Long.MIN_VALUE;

        if (maxNegativeGain != Integer.MIN_VALUE) {
            option2 = sum + maxNegativeGain;
        }

        return Math.max(option1, option2);
    }
}