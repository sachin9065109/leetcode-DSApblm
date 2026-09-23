class Solution {
    static final long INF = Long.MAX_VALUE / 4;

    public long minPartitionScore(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = INF;
        }

        prev[0] = 0;

        for (int groups = 1; groups <= k; groups++) {
            for (int i = 0; i <= n; i++) {
                curr[i] = INF;
            }

            solve(
                groups,
                groups,
                n,
                groups - 1,
                n - 1,
                prefix,
                prev,
                curr
            );

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    private void solve(
        int groups,
        int left,
        int right,
        int optLeft,
        int optRight,
        long[] prefix,
        long[] prev,
        long[] curr
    ) {
        if (left > right) {
            return;
        }

        int mid = left + (right - left) / 2;

        long best = INF;
        int bestPos = optLeft;

        int start = Math.max(optLeft, groups - 1);
        int end = Math.min(optRight, mid - 1);

        for (int p = start; p <= end; p++) {
            if (prev[p] == INF) {
                continue;
            }

            long sum = prefix[mid] - prefix[p];
            long cost = sum * (sum + 1) / 2;
            long candidate = prev[p] + cost;

            if (candidate < best) {
                best = candidate;
                bestPos = p;
            }
        }

        curr[mid] = best;

        solve(
            groups,
            left,
            mid - 1,
            optLeft,
            bestPos,
            prefix,
            prev,
            curr
        );

        solve(
            groups,
            mid + 1,
            right,
            bestPos,
            optRight,
            prefix,
            prev,
            curr
        );
    }
}