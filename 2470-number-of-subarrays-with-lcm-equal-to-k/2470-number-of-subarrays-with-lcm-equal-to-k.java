class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            long lcm = 1;

            for (int j = i; j < nums.length; j++) {
                lcm = lcm / gcd(lcm, nums[j]) * nums[j];

                if (lcm == k) {
                    count++;
                } else if (lcm > k || k % lcm != 0) {
                    break;
                }
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}