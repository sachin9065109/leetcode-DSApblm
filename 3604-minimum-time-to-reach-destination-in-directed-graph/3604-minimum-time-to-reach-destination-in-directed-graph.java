class Solution {
    static class State implements Comparable<State> {
        int node;
        long time;

        State(int node, long time) {
            this.node = node;
            this.time = time;
        }

        public int compareTo(State other) {
            return Long.compare(this.time, other.time);
        }
    }

    public int minTime(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int start = edge[2];
            int end = edge[3];

            graph[u].add(new int[]{v, start, end});
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];

        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            int u = cur.node;
            long time = cur.time;

            if (time != dist[u]) {
                continue;
            }

            if (u == n - 1) {
                return (int) time;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                long start = edge[1];
                long end = edge[2];

                if (time > end) {
                    continue;
                }

                long depart = Math.max(time, start);
                long arrival = depart + 1;

                if (arrival < dist[v]) {
                    dist[v] = arrival;
                    pq.offer(new State(v, arrival));
                }
            }
        }

        return -1;
    }
}