class Solution {

    int ans = 1;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        dfs(0, children, s);

        return ans;
    }

    private int dfs(int node, List<Integer>[] children, String s) {

      
        int best1 = 0;
        int best2 = 0;

        for (int child : children[node]) {

            int childPath = dfs(child, children, s);

            if (s.charAt(child) == s.charAt(node)) {
                continue;
            }

            if (childPath > best1) {
                best2 = best1;
                best1 = childPath;
            } else if (childPath > best2) {
                best2 = childPath;
            }
        }

        ans = Math.max(ans, best1 + best2 + 1);

        return best1 + 1;
    }
}