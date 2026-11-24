class Solution {
    static final int MOD = 1000000007;

    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(endPos - startPos);

        if (diff > k || (k - diff) % 2 != 0) {
            return 0;
        }

        int r = (k + diff) / 2;

        long[] fact = new long[k + 1];
        long[] invFact = new long[k + 1];

        fact[0] = 1;

        for (int i = 1; i <= k; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[k] = power(fact[k], MOD - 2);

        for (int i = k - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long ans = fact[k] * invFact[r] % MOD;
        ans = ans * invFact[k - r] % MOD;

        return (int) ans;
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}