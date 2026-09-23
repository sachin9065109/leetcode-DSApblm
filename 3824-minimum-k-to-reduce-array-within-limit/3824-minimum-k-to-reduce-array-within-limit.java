class Solution {
    public int minimumK(int[] nums) {
        int left = 1;
        int right = 100000;
        int ans = right;

        while (left <= right) {
            int k = left + (right - left) / 2;

            long operations = 0;
            long limit = (long) k * k;

            for (int num : nums) {
                operations += (num + (long) k - 1) / k;

                if (operations > limit) {
                    break;
                }
            }

            if (operations <= limit) {
                ans = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return ans;
    }
}