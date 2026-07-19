class Solution {

    public long maximumTotalDamage(int[] power) {

        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int x : power) {
            map.put(x, map.getOrDefault(x, 0L) + x);
        }

        int m = map.size();

        int[] value = new int[m];
        long[] total = new long[m];

        int idx = 0;
        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            value[idx] = e.getKey();
            total[idx] = e.getValue();
            idx++;
        }

        long[] dp = new long[m];

        for (int i = 0; i < m; i++) {

            long take = total[i];

            int l = 0, r = i - 1;
            int prev = -1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (value[mid] < value[i] - 2) {
                    prev = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (prev != -1)
                take += dp[prev];

            long skip = (i == 0) ? 0 : dp[i - 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[m - 1];
    }
}