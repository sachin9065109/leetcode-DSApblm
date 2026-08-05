class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        boolean[] marked = new boolean[n];
        long score = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0];
            int idx = cur[1];

            if (marked[idx]) continue;

            score += val;

            marked[idx] = true;
            if (idx > 0) marked[idx - 1] = true;
            if (idx < n - 1) marked[idx + 1] = true;
        }

        return score;
    }
}