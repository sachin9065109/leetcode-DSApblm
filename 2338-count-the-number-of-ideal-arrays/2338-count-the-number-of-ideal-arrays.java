class Solution {
    static final int MOD = 1000000007;

    public int idealArrays(int n, int maxValue) {
        long[][] comb = new long[n + 15][15];

        for (int i = 0; i < comb.length; i++) {
            comb[i][0] = 1;

            for (int j = 1; j < comb[i].length && j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        int[] spf = new int[maxValue + 1];

        for (int i = 2; i <= maxValue; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= maxValue; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        long answer = 0;

        for (int value = 1; value <= maxValue; value++) {
            int x = value;
            long ways = 1;

            while (x > 1) {
                int prime = spf[x];
                int exponent = 0;

                while (x % prime == 0) {
                    x /= prime;
                    exponent++;
                }

                ways = ways * comb[n + exponent - 1][exponent] % MOD;
            }

            answer = (answer + ways) % MOD;
        }

        return (int) answer;
    }
}