class Solution {
    public int maxGoodNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    int value = 0;

                    value = append(value, nums[i]);
                    value = append(value, nums[j]);
                    value = append(value, nums[k]);

                    ans = Math.max(ans, value);
                }
            }
        }

        return ans;
    }

    private int append(int value, int num) {
        int bits = 32 - Integer.numberOfLeadingZeros(num);
        return (value << bits) | num;
    }
}