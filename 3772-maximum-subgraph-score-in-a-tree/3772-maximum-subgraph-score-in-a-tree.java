class Solution {

    List<Integer>[] graph;
    int[] dp;
    int[] ans;
    int[] val;

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        val = new int[n];
        for (int i = 0; i < n; i++)
            val[i] = (good[i] == 1) ? 1 : -1;

        dp = new int[n];
        ans = new int[n];

        dfs1(0, -1);

        ans[0] = dp[0];

        dfs2(0, -1);

        return ans;
    }

    private void dfs1(int u, int parent) {
        dp[u] = val[u];

        for (int v : graph[u]) {
            if (v == parent) continue;
            dfs1(v, u);
            if (dp[v] > 0)
                dp[u] += dp[v];
        }
    }

    private void dfs2(int u, int parent) {
        for (int v : graph[u]) {
            if (v == parent) continue;

            int withoutChild = ans[u];
            if (dp[v] > 0)
                withoutChild -= dp[v];

            ans[v] = dp[v] + Math.max(0, withoutChild);

            dfs2(v, u);
        }
    }
}