class Solution {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;

        int[] pos = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                pos[cnt++] = i;
            }
        }

        long[] prefix = new long[cnt + 1];

        for (int i = 0; i < cnt; i++) {
            prefix[i + 1] = prefix[i] + (pos[i] - i);
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i + k <= cnt; i++) {
            int j = i + k - 1;
            int mid = i + k / 2;

            long median = pos[mid] - mid;

            long left = median * (mid - i)
                    - (prefix[mid] - prefix[i]);

            long right = (prefix[j + 1] - prefix[mid + 1])
                    - median * (j - mid);

            long cost = left + right;

            ans = Math.min(ans, cost);
        }

        return (int) ans;
    }
}