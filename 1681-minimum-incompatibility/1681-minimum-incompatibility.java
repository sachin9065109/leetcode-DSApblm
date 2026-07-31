class Solution {

    public int minimumIncompatibility(int[] nums, int k) {

        int n = nums.length;
        int size = n / k;

        int[] freq = new int[n + 1];
        for (int x : nums) {
            if (++freq[x] > k) {
                return -1;
            }
        }

        int total = 1 << n;
        int[] cost = new int[total];
        Arrays.fill(cost, -1);

        for (int mask = 0; mask < total; mask++) {

            if (Integer.bitCount(mask) != size) {
                continue;
            }

            boolean[] seen = new boolean[n + 1];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean ok = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) == 0) {
                    continue;
                }

                if (seen[nums[i]]) {
                    ok = false;
                    break;
                }

                seen[nums[i]] = true;
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            if (ok) {
                cost[mask] = max - min;
            }
        }

        int INF = 1_000_000_000;
        int[] dp = new int[total];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int mask = 0; mask < total; mask++) {

            if (dp[mask] == INF) {
                continue;
            }

            int remain = (~mask) & (total - 1);

            if (remain == 0) {
                continue;
            }

            int first = Integer.numberOfTrailingZeros(remain);

            for (int sub = remain; sub > 0; sub = (sub - 1) & remain) {

                if ((sub & (1 << first)) == 0) {
                    continue;
                }

                if (cost[sub] == -1) {
                    continue;
                }

                dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + cost[sub]);
            }
        }

        return dp[total - 1] == INF ? -1 : dp[total - 1];
    }
}