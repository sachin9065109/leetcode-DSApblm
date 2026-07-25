class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {

        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] g1 = buildGraph(n, edges1);
        List<Integer>[] g2 = buildGraph(m, edges2);

        int[] cnt1 = new int[n];

        for (int i = 0; i < n; i++) {
            cnt1[i] = bfs(i, k, g1);
        }

        int best = 0;

        if (k > 0) {
            for (int i = 0; i < m; i++) {
                best = Math.max(best, bfs(i, k - 1, g2));
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = cnt1[i] + best;
        }

        return ans;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        return graph;
    }

    private int bfs(int src, int limit, List<Integer>[] graph) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.offer(src);
        vis[src] = true;

        int dist = 0;
        int count = 0;

        while (!q.isEmpty() && dist <= limit) {

            int size = q.size();

            while (size-- > 0) {

                int node = q.poll();

                count++;

                for (int nei : graph[node]) {

                    if (!vis[nei]) {

                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }

            dist++;
        }

        return count;
    }
}