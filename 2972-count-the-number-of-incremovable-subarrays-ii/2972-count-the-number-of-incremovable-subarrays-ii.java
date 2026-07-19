class Solution {

    public long incremovableSubarrayCount(int[] nums) {

        int n = nums.length;

        int left = 0;
        while (left + 1 < n && nums[left] < nums[left + 1]) {
            left++;
        }

        if (left == n - 1) {
            return (long) n * (n + 1) / 2;
        }

        long ans = left + 2;

        int right = n - 1;

        while (right > 0) {

            if (right < n - 1 && nums[right] >= nums[right + 1]) {
                break;
            }

            while (left >= 0 && nums[left] >= nums[right]) {
                left--;
            }

            ans += left + 2;

            right--;
        }

        return ans;
    }
}