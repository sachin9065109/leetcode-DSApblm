class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = lowerBound(nums, i + 1, n, (long) lower - nums[i]);
            int right = lowerBound(nums, i + 1, n, (long) upper - nums[i] + 1);
            ans += (right - left);
        }

        return ans;
    }

    private int lowerBound(int[] nums, int l, int r, long target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long) nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}