class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int MAX = 80000;

        int[] diff = new int[MAX + 1];

        for (int x : nums1) diff[x]++;
        for (int x : nums2) diff[x]--;

        int ans = 0;

        for (int x = 1; x <= MAX; x++) {
            // total frequency must be even
            if ((Math.abs(diff[x]) & 1) == 1) {
                return -1;
            }

            if (diff[x] > 0) {
                ans += diff[x] / 2;
            }
        }

        return ans;
    }
}