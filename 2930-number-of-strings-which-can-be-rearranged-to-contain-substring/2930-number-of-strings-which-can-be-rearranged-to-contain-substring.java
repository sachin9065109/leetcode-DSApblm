class Solution {
    static final long MOD = 1000000007;

    public int stringCount(int n) {
        long total = pow(26, n);

        long a = pow(25, n);
        long c = (a + n * pow(25, n - 1)) % MOD;

        long ab = pow(24, n);
        long ac = (pow(24, n) + n * pow(24, n - 1)) % MOD;

        long abc = (pow(23, n) + n * pow(23, n - 1)) % MOD;

        long ans = total;

        ans = (ans - 2 * a % MOD - c + MOD) % MOD;
        ans = (ans + ab + 2 * ac) % MOD;
        ans = (ans - abc + MOD) % MOD;

        return (int) ans;
    }

    private long pow(long base, int exp) {
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