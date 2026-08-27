class Solution {
    static final long MOD = 1000000007L;

    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;

        List<long[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] conversion : conversions) {
            int source = conversion[0];
            int target = conversion[1];
            long factor = conversion[2];

            graph[source].add(new long[]{target, factor});
        }

        int[] answer = new int[n];
        answer[0] = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (long[] edge : graph[u]) {
                int v = (int) edge[0];
                long factor = edge[1];

                answer[v] = (int) ((answer[u] * factor) % MOD);

                queue.offer(v);
            }
        }

        return answer;
    }
}