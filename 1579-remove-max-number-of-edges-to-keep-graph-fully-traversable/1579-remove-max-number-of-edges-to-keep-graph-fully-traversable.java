class Solution {

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
        }

        int components() {
            int count = 0;

            for (int i = 1; i < parent.length; i++) {
                if (find(i) == i) {
                    count++;
                }
            }

            return count;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int used = 0;

        for (int[] edge : edges) {

            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {

                boolean aliceUsed = alice.union(u, v);
                boolean bobUsed = bob.union(u, v);

                if (aliceUsed || bobUsed) {
                    used++;
                }
            }
        }

        for (int[] edge : edges) {

            if (edge[0] == 1) {

                int u = edge[1];
                int v = edge[2];

                if (alice.union(u, v)) {
                    used++;
                }
            }
        }

        for (int[] edge : edges) {

            if (edge[0] == 2) {

                int u = edge[1];
                int v = edge[2];

                if (bob.union(u, v)) {
                    used++;
                }
            }
        }

        if (alice.components() != 1 ||
            bob.components() != 1) {

            return -1;
        }

        return edges.length - used;
    }
}