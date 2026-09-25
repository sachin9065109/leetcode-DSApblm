class Solution {
    public int minOperations(int k) {
        int ans = k - 1;

        for (int n = 1; n <= k; n++) {
            int value = (k + n - 1) / n;
            int operations = (value - 1) + (n - 1);
            ans = Math.min(ans, operations);
        }

        return ans;
    }
}