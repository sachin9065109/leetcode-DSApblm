class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;

        int left = k;
        int right = k;

        int minValue = nums[k];
        int ans = nums[k];

        while (left > 0 || right < n - 1) {

            if (left == 0) {
                right++;
            } else if (right == n - 1) {
                left--;
            } else if (nums[left - 1] > nums[right + 1]) {
                left--;
            } else {
                right++;
            }

            minValue = Math.min(minValue, Math.min(nums[left], nums[right]));
            ans = Math.max(ans, minValue * (right - left + 1));
        }

        return ans;
    }
}