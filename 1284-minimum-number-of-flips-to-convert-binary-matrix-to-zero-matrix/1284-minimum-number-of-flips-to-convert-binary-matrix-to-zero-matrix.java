class Solution {

    public int minFlips(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int start = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    start |= (1 << (i * n + j));
                }
            }
        }

        if (start == 0)
            return 0;

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int[][] dirs = {
                {0, 0},
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int mask = q.poll();

                if (mask == 0)
                    return steps;

                for (int i = 0; i < m; i++) {

                    for (int j = 0; j < n; j++) {

                        int next = mask;

                        for (int[] d : dirs) {

                            int r = i + d[0];
                            int c = j + d[1];

                            if (r >= 0 && r < m && c >= 0 && c < n) {

                                int bit = r * n + c;

                                next ^= (1 << bit);
                            }
                        }

                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}