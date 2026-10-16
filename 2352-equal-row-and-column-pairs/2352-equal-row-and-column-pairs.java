class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]).append(",");
            }

            map.put(row.toString(), map.getOrDefault(row.toString(), 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            StringBuilder col = new StringBuilder();

            for (int i = 0; i < n; i++) {
                col.append(grid[i][j]).append(",");
            }

            count += map.getOrDefault(col.toString(), 0);
        }

        return count;
    }
}