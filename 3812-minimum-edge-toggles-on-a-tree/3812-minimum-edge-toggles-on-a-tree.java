class Solution {

    List<int[]>[] graph;
    List<Integer> ans;
    int[] need;

    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new int[]{v, i});
            graph[v].add(new int[]{u, i});
        }

        need = new int[n];

        int total = 0;

        for (int i = 0; i < n; i++) {
            need[i] = (start.charAt(i) - '0') ^ (target.charAt(i) - '0');
            total += need[i];
        }

        if ((total & 1) == 1) {
            return new ArrayList<>(Arrays.asList(-1));
        }

        ans = new ArrayList<>();

        dfs(0, -1);

        Collections.sort(ans);

        return ans;
    }

    private int dfs(int node, int parent) {

        int cur = need[node];

        for (int[] nxt : graph[node]) {

            int child = nxt[0];
            int edgeIndex = nxt[1];

            if (child == parent) {
                continue;
            }

            int childParity = dfs(child, node);

            if (childParity == 1) {
                ans.add(edgeIndex);
                cur ^= 1;
            }
        }

        return cur;
    }
}