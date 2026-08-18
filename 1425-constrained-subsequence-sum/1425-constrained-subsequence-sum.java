class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            dp[i] = nums[i];

            if (!dq.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + dp[dq.peekFirst()]);
            }

            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}