class Solution {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[]{1};
        }

        int[] oddPart = beautifulArray((n + 1) / 2);

        int[] evenPart = beautifulArray(n / 2);

        int[] ans = new int[n];
        int idx = 0;

        for (int x : oddPart) {
            ans[idx++] = 2 * x - 1;
        }

        for (int x : evenPart) {
            ans[idx++] = 2 * x;
        }

        return ans;
    }
}