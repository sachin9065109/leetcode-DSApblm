class Solution {
    private int[] cost;
    private int ans = 0;

    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        dfs(1);
        return ans;
    }

    private int dfs(int node) {
        if (node * 2 > cost.length) {
            return cost[node - 1];
        }

        int left = dfs(node * 2);
        int right = dfs(node * 2 + 1);

        ans += Math.abs(left - right);

        return cost[node - 1] + Math.max(left, right);
    }
}