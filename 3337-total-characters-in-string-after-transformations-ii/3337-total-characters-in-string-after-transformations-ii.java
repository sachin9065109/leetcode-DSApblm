class Solution {
    static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] mat = new long[26][26];

        for (int i = 0; i < 26; i++) {
            int len = nums.get(i);
            for (int j = 1; j <= len; j++) {
                int nxt = (i + j) % 26;
                mat[i][nxt]++;
            }
        }

        long[][] res = power(mat, t);

        long[] base = new long[26];
        for (int i = 0; i < 26; i++) {
            base[i] = 1;
        }

        long[] value = new long[26];
        for (int i = 0; i < 26; i++) {
            long cur = 0;
            for (int j = 0; j < 26; j++) {
                cur = (cur + res[i][j] * base[j]) % MOD;
            }
            value[i] = cur;
        }

        long ans = 0;
        for (char c : s.toCharArray()) {
            ans = (ans + value[c - 'a']) % MOD;
        }

        return (int) ans;
    }

    private long[][] power(long[][] mat, long exp) {
        long[][] res = new long[26][26];

        for (int i = 0; i < 26; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }
            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[26][26];

        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                if (a[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return c;
    }
}