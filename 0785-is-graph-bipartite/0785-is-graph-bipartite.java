class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        
        int[] color = new int[n];
        Arrays.fill(color, -1);

      
        for (int i = 0; i < n; i++) {

            if (color[i] != -1) {
                continue;
            }

            color[i] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {

                int current = queue.poll();

                for (int neighbour : graph[current]) {

                    if (color[neighbour] == -1) {

                        color[neighbour] = 1 - color[current];

                        queue.add(neighbour);
                    }

                    else if (color[neighbour] == color[current]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
