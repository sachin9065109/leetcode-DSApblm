class Solution {
    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        List<int[]>[] incoming = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            incoming[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            incoming[e[1]].add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0] = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.dist != dist[cur.node]) continue;

            int u = cur.node;

            for (int[] nxt : graph[u]) {
                int v = nxt[0];
                long nd = cur.dist + nxt[1];

                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Pair(v, nd));
                }
            }

            for (int[] in : incoming[u]) {
                int v = in[0];
                long nd = cur.dist + 2L * in[1];

                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Pair(v, nd));
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}