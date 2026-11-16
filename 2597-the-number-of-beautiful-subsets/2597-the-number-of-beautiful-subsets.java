class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            boolean beautiful = true;

            for (int i = 0; i < n && beautiful; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }

                for (int j = i + 1; j < n; j++) {
                    if ((mask & (1 << j)) != 0 &&
                        Math.abs(nums[i] - nums[j]) == k) {
                        beautiful = false;
                        break;
                    }
                }
            }

            if (beautiful) {
                count++;
            }
        }

        return count;
    }
}