class Solution {

    public int kthSmallest(int[][] mat, int k) {

        List<Integer> sums = new ArrayList<>();

        for (int x : mat[0]) {
            sums.add(x);
        }

        if (sums.size() > k) {
            sums = sums.subList(0, k);
        }

        for (int i = 1; i < mat.length; i++) {
            sums = merge(sums, mat[i], k);
        }

        return sums.get(k - 1);
    }

    private List<Integer> merge(List<Integer> a, int[] b, int k) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((x, y) -> x[0] - y[0]);

        int limit = Math.min(a.size(), k);

        for (int i = 0; i < limit; i++) {
            pq.offer(new int[]{a.get(i) + b[0], i, 0});
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < k) {

            int[] cur = pq.poll();

            int sum = cur[0];
            int i = cur[1];
            int j = cur[2];

            res.add(sum);

            if (j + 1 < b.length) {
                pq.offer(new int[]{
                        a.get(i) + b[j + 1],
                        i,
                        j + 1
                });
            }
        }

        return res;
    }
}