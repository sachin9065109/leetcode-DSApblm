class Solution {
    static final int MOD = 1000000007;
    static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int squareFreeSubsets(int[] nums) {
        int[] count = new int[31];

        for (int x : nums) {
            count[x]++;
        }

        int[] masks = new int[31];
        boolean[] valid = new boolean[31];

        for (int x = 2; x <= 30; x++) {
            int value = x;
            int mask = 0;
            boolean ok = true;

            for (int i = 0; i < primes.length; i++) {
                int p = primes[i];
                int c = 0;

                while (value % p == 0) {
                    value /= p;
                    c++;
                }

                if (c >= 2) {
                    ok = false;
                    break;
                }

                if (c == 1) {
                    mask |= 1 << i;
                }
            }

            if (ok) {
                valid[x] = true;
                masks[x] = mask;
            }
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int x = 2; x <= 30; x++) {
            if (!valid[x] || count[x] == 0) {
                continue;
            }

            int mask = masks[x];
            long ways = count[x];

            long[] next = dp.clone();

            for (int state = 0; state < (1 << 10); state++) {
                if ((state & mask) == 0) {
                    int newState = state | mask;
                    next[newState] = (next[newState] + dp[state] * ways) % MOD;
                }
            }

            dp = next;
        }

        long result = 0;

        for (long ways : dp) {
            result = (result + ways) % MOD;
        }

        long ones = power(2, count[1]);
        result = result * ones % MOD;

        result = (result - 1 + MOD) % MOD;

        return (int) result;
    }

    private long power(long a, int b) {
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