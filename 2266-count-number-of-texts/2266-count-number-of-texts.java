class Solution {
    private static final int MOD = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = pressedKeys.charAt(i - 1);
            dp[i] = 0;

            for (int len = 1; len <= 4 && i - len >= 0; len++) {
                if (pressedKeys.charAt(i - len) != c) {
                    break;
                }

                if (len == 4 && c != '7' && c != '9') {
                    break;
                }

                dp[i] = (dp[i] + dp[i - len]) % MOD;
            }
        }

        return (int) dp[n];
    }
}