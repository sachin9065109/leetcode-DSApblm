class Solution {

    public int[] longestSpecialPath(int[][] edges, int[] nums) {

        int n = nums.length;

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int[] last = new int[50001];

        Arrays.fill(last, -1);

        int[] depth = new int[n];
        long[] dist = new long[n];

        
        int[] nodeAtDepth = new int[n];

        int[] stackNode = new int[n];
        int[] stackParent = new int[n];
        int[] stackEdgeIndex = new int[n];

        int[] stackLeft = new int[n];

        int[] stackPrevLast = new int[n];

        int top = 0;

        stackNode[0] = 0;
        stackParent[0] = -1;
        stackEdgeIndex[0] = 0;
        stackLeft[0] = 0;
        stackPrevLast[0] = -1;

        depth[0] = 0;
        dist[0] = 0;
        nodeAtDepth[0] = 0;

        last[nums[0]] = 0;

        long maxLength = 0;
        int minNodes = 1;

        while (top >= 0) {

            int u = stackNode[top];

            if (stackEdgeIndex[top] == graph[u].size()) {

                last[nums[u]] = stackPrevLast[top];

                top--;
                continue;
            }

            int[] edge = graph[u].get(stackEdgeIndex[top]);
            stackEdgeIndex[top]++;

            int v = edge[0];
            int weight = edge[1];

            if (v == stackParent[top]) {
                continue;
            }

            int newDepth = depth[u] + 1;

            dist[v] = dist[u] + weight;
            depth[v] = newDepth;

            nodeAtDepth[newDepth] = v;

            int prev = last[nums[v]];

          
            int newLeft = stackLeft[top];

            if (prev != -1) {
                newLeft = Math.max(newLeft, prev + 1);
            }

            stackPrevLast[top + 1] = prev;

            last[nums[v]] = newDepth;

            int startNode = nodeAtDepth[newLeft];

            long currentLength = dist[v] - dist[startNode];

            int currentNodes = newDepth - newLeft + 1;

            if (currentLength > maxLength) {

                maxLength = currentLength;
                minNodes = currentNodes;

            } else if (currentLength == maxLength) {

                minNodes = Math.min(minNodes, currentNodes);
            }

            top++;

            stackNode[top] = v;
            stackParent[top] = u;
            stackEdgeIndex[top] = 0;
            stackLeft[top] = newLeft;
        }

        return new int[]{
            (int) maxLength,
            minNodes
        };
    }
}