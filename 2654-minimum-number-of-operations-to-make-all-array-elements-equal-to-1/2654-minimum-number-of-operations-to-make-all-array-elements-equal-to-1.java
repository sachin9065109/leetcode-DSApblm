class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;

        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        if (ones > 0) {
            return n - ones;
        }

        int minLen = n + 1;

        for (int i = 0; i < n; i++) {
            int g = 0;

            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);

                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        if (minLen == n + 1) {
            return -1;
        }

        return minLen + n - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}