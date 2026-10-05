class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boolean[][] graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r = bombs[i][2];

                if (dx * dx + dy * dy <= r * r) {
                    graph[i][j] = true;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            max = Math.max(max, dfs(i, graph, visited));
        }

        return max;
    }

    private int dfs(int bomb, boolean[][] graph, boolean[] visited) {
        visited[bomb] = true;
        int count = 1;

        for (int i = 0; i < graph.length; i++) {
            if (graph[bomb][i] && !visited[i]) {
                count += dfs(i, graph, visited);
            }
        }

        return count;
    }
}