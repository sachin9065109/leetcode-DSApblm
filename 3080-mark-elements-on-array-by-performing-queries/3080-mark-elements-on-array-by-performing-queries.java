class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> nums[a] != nums[b]
                ? Integer.compare(nums[a], nums[b])
                : Integer.compare(a, b)
        );

        boolean[] marked = new boolean[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pq.offer(i);
        }

        long[] answer = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if (!marked[index]) {
                marked[index] = true;
                sum -= nums[index];
            }

            while (k > 0 && !pq.isEmpty()) {
                int idx = pq.poll();

                if (marked[idx]) {
                    continue;
                }

                marked[idx] = true;
                sum -= nums[idx];
                k--;
            }

            answer[i] = sum;
        }

        return answer;
    }
}