class Solution {
    static final long MOD = 1000000007L;

    public int countAnagrams(String s) {
        int n = s.length();

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);

        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        long ans = 1;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            int j = i;
            int[] freq = new int[26];

            while (j < n && s.charAt(j) != ' ') {
                freq[s.charAt(j) - 'a']++;
                j++;
            }

            int len = j - i;

            long ways = fact[len];

            for (int count : freq) {
                ways = ways * invFact[count] % MOD;
            }

            ans = ans * ways % MOD;
            i = j;
        }

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