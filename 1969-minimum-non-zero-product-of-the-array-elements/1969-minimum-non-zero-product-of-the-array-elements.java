class Solution {
    static final long MOD = 1000000007L;

    public int minNonZeroProduct(int p) {
        long max = (1L << p) - 1;
        long base = max - 1;
        long exponent = (1L << (p - 1)) - 1;

        long ans = max % MOD;
        ans = ans * power(base % MOD, exponent) % MOD;

        return (int) ans;
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}