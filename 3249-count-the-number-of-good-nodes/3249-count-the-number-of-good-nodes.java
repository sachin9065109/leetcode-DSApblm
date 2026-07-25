class Solution {

    List<Integer>[] graph;
    int good = 0;

    public int countGoodNodes(int[][] edges) {

        int n = edges.length + 1;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(0, -1);

        return good;
    }

    private int dfs(int node, int parent) {

        int subtreeSize = 1;

        int expected = -1;
        boolean ok = true;

        for (int child : graph[node]) {

            if (child == parent)
                continue;

            int size = dfs(child, node);

            if (expected == -1)
                expected = size;
            else if (expected != size)
                ok = false;

            subtreeSize += size;
        }

        if (ok)
            good++;

        return subtreeSize;
    }
}