class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int cost = e[2];

            graph[u].add(new int[]{v, cost});
            maxCost = Math.max(maxCost, cost);
        }

        int[] indegree = new int[n];

        for (int[] e : edges) {
            indegree[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[n];
        int index = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[index++] = u;

            for (int[] edge : graph[u]) {
                int v = edge[0];

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int low = 0;
        int high = maxCost;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(mid, graph, online, k, topo)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canReach(
        int minScore,
        List<int[]>[] graph,
        boolean[] online,
        long k,
        int[] topo
    ) {
        int n = online.length;

        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];

        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) {
                continue;
            }

            if (!online[u] && u != 0 && u != n - 1) {
                continue;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];

                if (cost < minScore) {
                    continue;
                }

                if (!online[v] && v != n - 1) {
                    continue;
                }

                long newCost = dist[u] + cost;

                if (newCost <= k && newCost < dist[v]) {
                    dist[v] = newCost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}