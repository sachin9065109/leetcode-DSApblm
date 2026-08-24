class Solution {

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
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
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return false;
            }

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    private boolean possible(int n, int[][] edges, int k, int t) {

        DSU dsu = new DSU(n);

        int components = n;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

          
            if (time > t) {
                if (dsu.union(u, v)) {
                    components--;
                }
            }
        }

        return components >= k;
    }

    public int minTime(int n, int[][] edges, int k) {

        
        if (possible(n, edges, k, 0)) {
            return 0;
        }

        int low = 1;
        int high = 1_000_000_000;
        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(n, edges, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}