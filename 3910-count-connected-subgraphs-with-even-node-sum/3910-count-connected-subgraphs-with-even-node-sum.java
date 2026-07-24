class Solution {

    public int evenSumSubgraphs(int[] nums, int[][] edges) {

        int n = nums.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;

        for (int mask = 1; mask < (1 << n); mask++) {

            int sum = 0;
            int nodes = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    nodes++;
                }
            }

            if ((sum & 1) == 1)
                continue;

            boolean[] vis = new boolean[n];

            int start = -1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    start = i;
                    break;
                }
            }

            int visited = dfs(start, mask, graph, vis);

            if (visited == nodes)
                ans++;
        }

        return ans;
    }

    private int dfs(int node, int mask,
                    List<Integer>[] graph,
                    boolean[] vis) {

        vis[node] = true;
        int cnt = 1;

        for (int nei : graph[node]) {

            if ((mask & (1 << nei)) == 0)
                continue;

            if (vis[nei])
                continue;

            cnt += dfs(nei, mask, graph, vis);
        }

        return cnt;
    }
}