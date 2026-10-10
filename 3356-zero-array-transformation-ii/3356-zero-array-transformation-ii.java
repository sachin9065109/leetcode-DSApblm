class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int left = 0, right = q;

        if (!canMakeZero(nums, queries, q)) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakeZero(nums, queries, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            diff[r + 1] -= val;
        }

        int available = 0;

        for (int i = 0; i < n; i++) {
            available += diff[i];

            if (available < nums[i]) {
                return false;
            }
        }

        return true;
    }
}