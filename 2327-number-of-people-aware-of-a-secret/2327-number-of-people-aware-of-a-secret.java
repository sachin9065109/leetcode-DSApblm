class Solution {

    public int peopleAwareOfSecret(int n, int delay, int forget) {

        final long MOD = 1000000007L;

        long[] dp = new long[n + 1];

        dp[1] = 1;

        long sharing = 0;

        for (int day = 2; day <= n; day++) {

            int start = day - delay;
            if (start >= 1) {
                sharing = (sharing + dp[start]) % MOD;
            }

            int stop = day - forget;
            if (stop >= 1) {
                sharing = (sharing - dp[stop] + MOD) % MOD;
            }

            dp[day] = sharing;
        }

        long answer = 0;

        int firstDay = Math.max(1, n - forget + 1);

        for (int day = firstDay; day <= n; day++) {
            answer = (answer + dp[day]) % MOD;
        }

        return (int) answer;
    }
}