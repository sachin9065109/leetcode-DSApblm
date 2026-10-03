class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long ans = 0;
        long consecutiveZeros = 0;

        for (int num : nums) {

            if (num == 0) {
                consecutiveZeros++;

                ans += consecutiveZeros;
            } else {
                consecutiveZeros = 0;
            }
        }

        return ans;
    }
}