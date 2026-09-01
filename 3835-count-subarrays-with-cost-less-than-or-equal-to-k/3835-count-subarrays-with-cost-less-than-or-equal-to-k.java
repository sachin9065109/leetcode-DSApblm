class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        long ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            while (left <= right) {
                long max = nums[maxDeque.peekFirst()];
                long min = nums[minDeque.peekFirst()];
                long length = right - left + 1L;

                long cost = (max - min) * length;

                if (cost <= k) {
                    break;
                }

                if (!maxDeque.isEmpty() && maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (!minDeque.isEmpty() && minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            ans += right - left + 1L;
        }

        return ans;
    }
}