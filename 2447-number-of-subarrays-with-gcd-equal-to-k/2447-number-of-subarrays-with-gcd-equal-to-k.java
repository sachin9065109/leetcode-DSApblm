class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int gcd = 0;

            for (int j = i; j < nums.length; j++) {
                gcd = gcd(gcd, nums[j]);

                if (gcd == k) {
                    ans++;
                } else if (gcd < k) {
                    break;
                }
            }
        }

        return ans;
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