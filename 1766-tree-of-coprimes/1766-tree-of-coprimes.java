import java.util.*;

class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        ArrayList<int[]>[] path = new ArrayList[51];
        for (int i = 0; i <= 50; i++) {
            path[i] = new ArrayList<>();
        }

        int[] stackNode = new int[2 * n];
        int[] stackParent = new int[2 * n];
        int[] stackDepth = new int[2 * n];
        boolean[] exit = new boolean[2 * n];

        int top = 0;
        stackNode[top] = 0;
        stackParent[top] = -1;
        stackDepth[top] = 0;
        exit[top] = false;
        top++;

        while (top > 0) {
            top--;

            int node = stackNode[top];
            int parent = stackParent[top];
            int depth = stackDepth[top];

            if (exit[top]) {
                path[nums[node]].remove(path[nums[node]].size() - 1);
                continue;
            }

            int bestNode = -1;
            int bestDepth = -1;

            for (int value = 1; value <= 50; value++) {
                if (!path[value].isEmpty() && gcd(nums[node], value) == 1) {
                    int[] candidate = path[value].get(path[value].size() - 1);

                    if (candidate[1] > bestDepth) {
                        bestDepth = candidate[1];
                        bestNode = candidate[0];
                    }
                }
            }

            ans[node] = bestNode;

            path[nums[node]].add(new int[]{node, depth});

            stackNode[top] = node;
            stackParent[top] = parent;
            stackDepth[top] = depth;
            exit[top] = true;
            top++;

            for (int next : graph[node]) {
                if (next != parent) {
                    stackNode[top] = next;
                    stackParent[top] = node;
                    stackDepth[top] = depth + 1;
                    exit[top] = false;
                    top++;
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}