class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }

        long increase = 0;
        long decrease = 0;

        for (int i = 0; i < n; i++) {
            long diff = (long) nums2[i] - nums1[i];

            if (diff % k != 0) {
                return -1;
            }

            if (diff > 0) {
                increase += diff;
            } else {
                decrease -= diff;
            }
        }

        if (increase != decrease) {
            return -1;
        }

        return increase / k;
    }
}