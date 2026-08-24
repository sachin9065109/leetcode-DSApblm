class Graph {

    private int n;
    private List<int[]>[] graph;

    public Graph(int n, int[][] edges) {

        this.n = n;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            graph[from].add(new int[]{to, cost});
        }
    }

    public void addEdge(int[] edge) {

        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];

        graph[from].add(new int[]{to, cost});
    }

    public int shortestPath(int node1, int node2) {

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[node1] = 0;

        pq.offer(new long[]{0, node1});

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long currentDist = current[0];
            int node = (int) current[1];

            if (currentDist != dist[node]) {
                continue;
            }

            if (node == node2) {
                return (int) currentDist;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int cost = edge[1];

                long newDist = currentDist + cost;

                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    pq.offer(new long[]{
                        newDist,
                        next
                    });
                }
            }
        }

        return -1;
    }
}
/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */