class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int common = 0;

                boolean[] a = new boolean[101];
                boolean[] b = new boolean[101];

                for (int x : properties[i]) {
                    a[x] = true;
                }

                for (int x : properties[j]) {
                    b[x] = true;
                }

                for (int x = 1; x <= 100; x++) {
                    if (a[x] && b[x]) {
                        common++;
                    }
                }

                if (common >= k) {
                    union(i, j);
                }
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                components++;
            }
        }

        return components;
    }
}