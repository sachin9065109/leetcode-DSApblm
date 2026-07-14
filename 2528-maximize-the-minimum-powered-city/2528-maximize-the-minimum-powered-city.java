class Solution {

    public long maxPower(int[] stations, int r, int k) {

        int n = stations.length;

        long[] power = new long[n];
        long window = 0;

        for (int i = 0; i < n; i++) {
            window += stations[i];

            if (i > 2 * r)
                window -= stations[i - 2 * r - 1];

            if (i >= r)
                power[i - r] = window;
        }

        for (int i = Math.max(0, n - r); i < n; i++) {
            if (i - r - 1 >= 0)
                window -= stations[i - r - 1];
            power[i] = window;
        }

        long low = 0;
        long high = 0;

        for (int x : stations)
            high += x;

        high += k;

        while (low < high) {

            long mid = (low + high + 1) / 2;

            if (canAchieve(power, r, k, mid))
                low = mid;
            else
                high = mid - 1;
        }

        return low;
    }

    private boolean canAchieve(long[] power, int r, int k, long target) {

        int n = power.length;

        long[] diff = new long[n + 1];

        long added = 0;

        long remain = k;

        for (int i = 0; i < n; i++) {

            added += diff[i];

            long current = power[i] + added;

            if (current < target) {

                long need = target - current;

                remain -= need;

                if (remain < 0)
                    return false;

                added += need;

                int end = Math.min(n, i + 2 * r + 1);

                diff[end] -= need;
            }
        }

        return true;
    }
}