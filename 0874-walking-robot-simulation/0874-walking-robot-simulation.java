class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<Long> set = new HashSet<>();

        for (int[] ob : obstacles) {
            long key = (((long) ob[0]) << 32) | (ob[1] & 0xffffffffL);
            set.add(key);
        }

        int[][] dirs = {
            {0, 1},   
            {1, 0},   
            {0, -1},
            {-1, 0}   
        };

        int dir = 0;
        int x = 0, y = 0;
        int ans = 0;

        for (int cmd : commands) {

            if (cmd == -1) {
                dir = (dir + 1) % 4;
            }
            else if (cmd == -2) {
                dir = (dir + 3) % 4;
            }
            else {

                for (int step = 0; step < cmd; step++) {

                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    long key = (((long) nx) << 32) | (ny & 0xffffffffL);

                    if (set.contains(key))
                        break;

                    x = nx;
                    y = ny;

                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }

        return ans;
    }
}