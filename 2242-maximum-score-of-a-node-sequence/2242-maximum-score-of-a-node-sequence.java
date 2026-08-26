class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;

        int[][] best = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], -1);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            addNeighbor(best[u], v, scores);
            addNeighbor(best[v], u, scores);
        }

        long ans = -1;

        for (int[] edge : edges) {
            int b = edge[0];
            int c = edge[1];

            
            for (int a : best[b]) {
                if (a == -1 || a == c) {
                    continue;
                }

                for (int d : best[c]) {
                    if (d == -1 || d == b || d == a) {
                        continue;
                    }

                    long sum = (long) scores[a]
                            + scores[b]
                            + scores[c]
                            + scores[d];

                    ans = Math.max(ans, sum);
                }
            }
        }

        return (int) ans;
    }

    private void addNeighbor(int[] best, int node, int[] scores) {
        for (int i = 0; i < 3; i++) {
            if (best[i] == -1 || scores[node] > scores[best[i]]) {
                for (int j = 2; j > i; j--) {
                    best[j] = best[j - 1];
                }

                best[i] = node;
                break;
            }
        }
    }
}