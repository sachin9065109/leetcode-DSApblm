class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] answer = new int[n];

        dfs(0, -1, graph, labels, answer);

        return answer;
    }

    private int[] dfs(int node, int parent, List<Integer>[] graph,
                      String labels, int[] answer) {

        int[] count = new int[26];

        for (int neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }

            int[] childCount = dfs(
                neighbor,
                node,
                graph,
                labels,
                answer
            );

            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }

        int currentLabel = labels.charAt(node) - 'a';

        count[currentLabel]++;

        answer[node] = count[currentLabel];

        return count;
    }
}