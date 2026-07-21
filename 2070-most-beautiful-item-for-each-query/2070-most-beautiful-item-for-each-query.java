class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int n = items.length;

        int[] prices = new int[n];
        int[] maxBeauty = new int[n];

        int best = 0;

        for (int i = 0; i < n; i++) {
            prices[i] = items[i][0];
            best = Math.max(best, items[i][1]);
            maxBeauty[i] = best;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx = upperBound(prices, queries[i]);

            if (idx == -1) {
                ans[i] = 0;
            } else {
                ans[i] = maxBeauty[idx];
            }
        }

        return ans;
    }

    private int upperBound(int[] prices, int target) {
        int low = 0;
        int high = prices.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}