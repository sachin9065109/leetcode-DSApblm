class Solution {

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        for (int q : quantities) {
            high = Math.max(high, q);
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canDistribute(quantities, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canDistribute(int[] quantities, int n, int x) {

        long stores = 0;

        for (int q : quantities) {
            stores += (q + x - 1) / x; // ceil(q / x)

            if (stores > n) {
                return false;
            }
        }

        return true;
    }
}