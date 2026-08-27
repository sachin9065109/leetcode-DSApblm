class Solution {

    int[] parent;
    int[] size;
    int[] xor;

    public int numberOfEdgesAdded(int n, int[][] edges) {

        parent = new int[n];
        size = new int[n];
        xor = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            xor[i] = 0;
        }

        int answer = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int rootU = find(u);
            int xorU = xor[u];

            int rootV = find(v);
            int xorV = xor[v];

            if (rootU != rootV) {

                parent[rootU] = rootV;

                xor[rootU] = xorU ^ xorV ^ w;

                size[rootV] += size[rootU];

                answer++;

            } else {

                if ((xorU ^ xorV) == w) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        int p = parent[x];

        parent[x] = find(p);

        xor[x] ^= xor[p];

        return parent[x];
    }
}