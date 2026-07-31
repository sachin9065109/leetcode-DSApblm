class DetectSquares {

    private Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!map.containsKey(x)) {
            return 0;
        }

        int ans = 0;
        Map<Integer, Integer> sameX = map.get(x);

        for (int ny : sameX.keySet()) {
            if (ny == y) {
                continue;
            }

            int side = ny - y;

            ans += sameX.get(ny)
                    * map.getOrDefault(x + side, Collections.emptyMap()).getOrDefault(y, 0)
                    * map.getOrDefault(x + side, Collections.emptyMap()).getOrDefault(ny, 0);

            ans += sameX.get(ny)
                    * map.getOrDefault(x - side, Collections.emptyMap()).getOrDefault(y, 0)
                    * map.getOrDefault(x - side, Collections.emptyMap()).getOrDefault(ny, 0);
        }

        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */