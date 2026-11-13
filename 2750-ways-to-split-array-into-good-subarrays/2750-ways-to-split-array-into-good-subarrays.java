class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final long MOD = 1_000_000_007L;

        long ans = 1;
        int prevOne = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prevOne != -1) {
                    ans = (ans * (i - prevOne)) % MOD;
                }
                prevOne = i;
            }
        }

        if (prevOne == -1) {
            return 0;
        }

        return (int) ans;
    }
}