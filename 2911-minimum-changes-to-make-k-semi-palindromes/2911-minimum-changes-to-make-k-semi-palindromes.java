class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                int best = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int start = 0; start < d; start++) {
                        int left = l + start;
                        int right = l + start + ((len - 1 - start) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[l][r] = best;
            }
        }

        int INF = 1_000_000;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            java.util.Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int groups = 1; groups <= k; groups++) {
            for (int end = 2 * groups; end <= n; end++) {
                for (int start = 2 * (groups - 1); start <= end - 2; start++) {
                    if (dp[groups - 1][start] == INF) {
                        continue;
                    }

                    dp[groups][end] = Math.min(
                        dp[groups][end],
                        dp[groups - 1][start] + cost[start][end - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}