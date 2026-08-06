class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long cost = 0;
        int total = 0;
        int majority = -1;
        int majorityCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                cost += i;
                total++;

                if (majorityCount == 0) {
                    majority = nums1[i];
                    majorityCount = 1;
                } else if (majority == nums1[i]) {
                    majorityCount++;
                } else {
                    majorityCount--;
                }
            }
        }

        if (total == 0) return 0;

        majorityCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i] && nums1[i] == majority) {
                majorityCount++;
            }
        }

        for (int i = 0; i < n && majorityCount * 2 > total; i++) {
            if (nums1[i] != nums2[i] && nums1[i] != majority && nums2[i] != majority) {
                cost += i;
                total++;
            }
        }

        return majorityCount * 2 > total ? -1 : cost;
    }
}