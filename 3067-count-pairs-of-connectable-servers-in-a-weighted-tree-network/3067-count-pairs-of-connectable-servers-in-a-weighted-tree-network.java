class Solution {

    static class Edge {
        int to;
        int weight;

        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    List<Edge>[] graph;
    int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {

        int n = edges.length + 1;
        this.signalSpeed = signalSpeed;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            graph[e[1]].add(new Edge(e[0], e[2]));
        }

        int[] ans = new int[n];

        for (int root = 0; root < n; root++) {

            int sum = 0;

            for (Edge edge : graph[root]) {

                int cnt = dfs(edge.to, root, edge.weight);

                ans[root] += sum * cnt;

                sum += cnt;
            }
        }

        return ans;
    }

    private int dfs(int node, int parent, long dist) {

        int count = 0;

        if (dist % signalSpeed == 0)
            count++;

        for (Edge next : graph[node]) {

            if (next.to == parent)
                continue;

            count += dfs(next.to, node, dist + next.weight);
        }

        return count;
    }
}