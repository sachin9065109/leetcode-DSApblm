class Solution {
    public long minimumPerimeter(long neededApples) {
        long low = 1;
        long high = 1000000;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (apples(mid) >= neededApples) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low * 8;
    }

    private long apples(long n) {
        return 2 * n * (n + 1) * (2 * n + 1);
    }
}