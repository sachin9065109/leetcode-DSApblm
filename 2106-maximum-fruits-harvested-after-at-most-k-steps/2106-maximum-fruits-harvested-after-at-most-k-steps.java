class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        int[] pos = new int[n];
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }

        long ans = 0;

        for (int left = 0; left <= k; left++) {
            int right = Math.max(k - 2 * left, (k - left) / 2);

            int l = startPos - left;
            int r = startPos + right;

            int li = lowerBound(pos, l);
            int ri = upperBound(pos, r);

            ans = Math.max(ans, prefix[ri] - prefix[li]);
        }

        for (int right = 0; right <= k; right++) {
            int left = Math.max(k - 2 * right, (k - right) / 2);

            int l = startPos - left;
            int r = startPos + right;

            int li = lowerBound(pos, l);
            int ri = upperBound(pos, r);

            ans = Math.max(ans, prefix[ri] - prefix[li]);
        }

        return (int) ans;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}