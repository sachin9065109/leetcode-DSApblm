class Solution {

    static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {

        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] <= nums[right])
                maxDeque.pollLast();

            maxDeque.offerLast(right);

            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] >= nums[right])
                minDeque.pollLast();

            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {

                if (maxDeque.peekFirst() == left)
                    maxDeque.pollFirst();

                if (minDeque.peekFirst() == left)
                    minDeque.pollFirst();

                left++;
            }

            long ways;

            if (left == 0)
                ways = prefix[right];
            else
                ways = (prefix[right] - prefix[left - 1] + MOD) % MOD;

            dp[right + 1] = ways;

            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}