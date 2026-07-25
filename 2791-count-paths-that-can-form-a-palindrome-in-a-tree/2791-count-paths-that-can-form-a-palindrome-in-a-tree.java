class Solution {

    public long countPalindromePaths(List<Integer> parent, String s) {

        int n = parent.size();

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int p = parent.get(i);
            int bit = s.charAt(i) - 'a';
            graph[p].add(new int[]{i, bit});
        }

        int[] mask = new int[n];
        dfs(0, 0, graph, mask);

        Map<Integer, Integer> freq = new HashMap<>();
        long ans = 0;

        for (int m : mask) {
            freq.put(m, freq.getOrDefault(m, 0) + 1);
        }

        for (int m : mask) {

            freq.put(m, freq.get(m) - 1);

            ans += freq.getOrDefault(m, 0);

            for (int b = 0; b < 26; b++) {
                ans += freq.getOrDefault(m ^ (1 << b), 0);
            }
        }

        return ans;
    }

    private void dfs(int node, int curMask,
                     List<int[]>[] graph,
                     int[] mask) {

        mask[node] = curMask;

        for (int[] next : graph[node]) {
            int child = next[0];
            int bit = next[1];
            dfs(child, curMask ^ (1 << bit), graph, mask);
        }
    }
}