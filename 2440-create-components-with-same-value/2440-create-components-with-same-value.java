import java.util.*;

class Solution {

    List<Integer>[] graph;
    int[] nums;
    int target;
    int components;

    public int componentValue(int[] nums, int[][] edges) {

        int n = nums.length;
        this.nums = nums;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int totalSum = 0;

        for (int x : nums) {
            totalSum += x;
        }

        for (int k = n; k >= 1; k--) {

            if (totalSum % k != 0) {
                continue;
            }

            target = totalSum / k;
            components = 0;

            int remaining = dfs(0, -1);

            if (remaining == 0 && components == k) {
                return k - 1;
            }
        }

        return 0;
    }

    private int dfs(int node, int parent) {

        int sum = nums[node];

        for (int next : graph[node]) {

            if (next == parent) {
                continue;
            }

            int childSum = dfs(next, node);

            if (childSum == -1) {
                return -1;
            }

            sum += childSum;
        }

        if (sum == target) {
            components++;
            return 0;
        }

        if (sum > target) {
            return -1;
        }

        return sum;
    }
}