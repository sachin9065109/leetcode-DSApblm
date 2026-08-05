class Solution {
    public int valueAfterKSeconds(int n, int k) {
        final int MOD = 1_000_000_007;

        int[] a = new int[n];
        Arrays.fill(a, 1);

        for (int t = 0; t < k; t++) {
            for (int i = 1; i < n; i++) {
                a[i] = (a[i] + a[i - 1]) % MOD;
            }
        }

        return a[n - 1];
    }
}