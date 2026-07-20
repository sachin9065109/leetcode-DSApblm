class Solution {
    public int[] smallestSubarrays(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int[] last = new int[30];

        for (int i = 0; i < 30; i++) {
            last[i] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {

            int farthest = i;

            for (int bit = 0; bit < 30; bit++) {

                if (((nums[i] >> bit) & 1) == 1) {
                    last[bit] = i;
                }

                if (last[bit] != -1) {
                    farthest = Math.max(farthest, last[bit]);
                }
            }

            ans[i] = farthest - i + 1;
        }

        return ans;
    }
}