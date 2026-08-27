class Solution {
    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (size[pa] < size[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];

        return true;
    }

    public int minCost(int n, int[][] edges, int k) {
        if (k >= n) {
            return 0;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int components = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (union(u, v)) {
                components--;

                if (components == k) {
                    return w;
                }
            }
        }

        return 0;
    }
}