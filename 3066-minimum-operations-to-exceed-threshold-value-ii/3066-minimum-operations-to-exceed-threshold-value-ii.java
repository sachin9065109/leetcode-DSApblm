class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer((long) num);
        }

        int operations = 0;

        while (pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();

            long value = 2 * x + y;
            pq.offer(value);

            operations++;
        }

        return operations;
    }
}