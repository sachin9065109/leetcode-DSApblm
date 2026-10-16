class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] blocked = new boolean[n];

        for (int node : restricted) {
            blocked[node] = true;
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, blocked, visited);
    }

    private int dfs(int node, List<List<Integer>> graph,
                    boolean[] blocked, boolean[] visited) {
        if (blocked[node] || visited[node]) {
            return 0;
        }

        visited[node] = true;
        int count = 1;

        for (int neighbor : graph.get(node)) {
            count += dfs(neighbor, graph, blocked, visited);
        }

        return count;
    }
}