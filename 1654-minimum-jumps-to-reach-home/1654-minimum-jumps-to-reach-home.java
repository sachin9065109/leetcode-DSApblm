class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int limit = 6000;

        boolean[] blocked = new boolean[limit + 1];
        for (int pos : forbidden) {
            blocked[pos] = true;
        }

        boolean[][] visited = new boolean[limit + 1][2];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int pos = curr[0];
                int lastBack = curr[1];

                if (pos == x) {
                    return jumps;
                }

                int forward = pos + a;

                if (forward <= limit &&
                    !blocked[forward] &&
                    !visited[forward][0]) {

                    visited[forward][0] = true;
                    q.offer(new int[]{forward, 0});
                }

                int backward = pos - b;

                if (backward >= 0 &&
                    !blocked[backward] &&
                    lastBack == 0 &&
                    !visited[backward][1]) {

                    visited[backward][1] = true;
                    q.offer(new int[]{backward, 1});
                }
            }

            jumps++;
        }

        return -1;
    }
}