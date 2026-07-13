class Solution {

    int components = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(0, -1, graph, values, k);

        return components;
    }

    private long dfs(int node, int parent,
                     List<Integer>[] graph,
                     int[] values,
                     int k) {

        long sum = values[node];

        for (int child : graph[node]) {

            if (child == parent)
                continue;

            sum += dfs(child, node, graph, values, k);
        }

        if (sum % k == 0) {
            components++;
            return 0;
        }

        return sum;
    }
}