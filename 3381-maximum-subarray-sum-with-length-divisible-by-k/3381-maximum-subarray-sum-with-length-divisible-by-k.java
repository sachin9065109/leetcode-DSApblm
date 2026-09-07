class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        int n = nums.length;

        long[] minPrefix = new long[k];

        long INF = Long.MAX_VALUE / 4;

        for (int i = 0; i < k; i++) {
            minPrefix[i] = INF;
        }

        minPrefix[0] = 0;

        long prefix = 0;

        long ans = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {

            prefix += nums[i - 1];

            int rem = i % k;

            
            if (minPrefix[rem] != INF) {

                ans = Math.max(ans, prefix - minPrefix[rem]);
            }

            minPrefix[rem] = Math.min(minPrefix[rem], prefix);
        }

        return ans;
    }
}