class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int INF = Integer.MAX_VALUE / 2;

        for (int i = 1; i <= n; i++) {
            dp[i] = INF;
        }

        for (int i = 1; i <= n; i++) {
            int[] freq = new int[n];
            int trimmed = 0;

            for (int j = i; j >= 1; j--) {
                int x = nums[j - 1];
                freq[x]++;

                if (freq[x] == 2) {
                    trimmed += 2;
                } else if (freq[x] > 2) {
                    trimmed++;
                }

                dp[i] = Math.min(dp[i], dp[j - 1] + k + trimmed);
            }
        }

        return dp[n];
    }
}