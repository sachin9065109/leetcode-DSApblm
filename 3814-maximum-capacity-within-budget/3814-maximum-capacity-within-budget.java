class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;

        int[][] machines = new int[n][2];

        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }

        Arrays.sort(machines, Comparator.comparingInt(a -> a[0]));

        int[] prefixMax = new int[n];
        prefixMax[0] = machines[0][1];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], machines[i][1]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                ans = Math.max(ans, machines[i][1]);
            }

            int limit = budget - machines[i][0];

            int left = 0;
            int right = i - 1;
            int best = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (machines[mid][0] < limit) {
                    best = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (best != -1) {
                ans = Math.max(ans, machines[i][1] + prefixMax[best]);
            }
        }

        return ans;
    }
}