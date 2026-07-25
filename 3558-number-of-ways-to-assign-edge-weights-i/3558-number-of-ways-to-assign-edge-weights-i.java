class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int maxDepth = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
            if (!q.isEmpty()) {
                maxDepth++;
            }
        }
        
        long res = 1;
        long base = 2;
        int exp = maxDepth - 1;
        int mod = 1000000007;
        
        if (exp < 0) {
            return 0;
        }
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        
        return (int) res;
    }
}