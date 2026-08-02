class Solution {

    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canForm(nums, p, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canForm(int[] nums, int p, int limit) {

        int count = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] <= limit) {
                count++;
                i++;
            }

            if (count >= p) {
                return true;
            }
        }

        return false;
    }
}