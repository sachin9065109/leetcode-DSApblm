class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canRob(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canRob(int[] nums, int k, int limit) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= limit) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= k;
    }
}