class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int mask = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((mask & nums[right]) != 0) {
                mask ^= nums[left];
                left++;
            }

            mask |= nums[right];
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}