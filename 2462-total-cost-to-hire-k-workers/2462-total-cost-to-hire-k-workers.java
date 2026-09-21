class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                    : Integer.compare(a[1], b[1])
        );

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{costs[left], left});
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{costs[right], right});
            right--;
        }

        for (int i = 0; i < k; i++) {
            int[] worker = pq.poll();
            total += worker[0];

            int index = worker[1];

            if (left <= right) {
                if (index < left) {
                    pq.offer(new int[]{costs[left], left});
                    left++;
                } else {
                    pq.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }

        return total;
    }
}