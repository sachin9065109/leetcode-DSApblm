class Solution {

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public int minGenerations(int[][] points, int[] target) {

        boolean[][][] vis = new boolean[7][7][7];
        List<Point> all = new ArrayList<>();

        for (int[] p : points) {
            vis[p[0]][p[1]][p[2]] = true;
            all.add(new Point(p[0], p[1], p[2]));
        }

        if (vis[target[0]][target[1]][target[2]])
            return 0;

        if (all.size() < 2)
            return -1;

        int generation = 0;

        while (true) {

            generation++;
            List<Point> next = new ArrayList<>();

            int n = all.size();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    Point a = all.get(i);
                    Point b = all.get(j);

                    int x = (a.x + b.x) / 2;
                    int y = (a.y + b.y) / 2;
                    int z = (a.z + b.z) / 2;

                    if (!vis[x][y][z]) {
                        vis[x][y][z] = true;

                        Point p = new Point(x, y, z);
                        next.add(p);

                        if (x == target[0] && y == target[1] && z == target[2])
                            return generation;
                    }
                }
            }

            if (next.isEmpty())
                return -1;

            all.addAll(next);
        }
    }
}