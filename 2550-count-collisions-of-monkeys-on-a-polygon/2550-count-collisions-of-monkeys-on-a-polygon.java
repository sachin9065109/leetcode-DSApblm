class Solution {
    public int monkeyMove(int n) {
        final long MOD = 1000000007L;

        if (n == 3) {
            return 6;
        }

        long total = powerMod(2, n, MOD);

        return (int) ((total - 2 + MOD) % MOD);
    }

    private long powerMod(long base, long exp, long mod) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}