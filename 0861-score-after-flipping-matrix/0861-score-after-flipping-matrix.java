class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int score = 0;

        for (int j = 0; j < n; j++) {
            int ones = 0;

            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1) {
                    ones += grid[i][j];
                } else {
                    ones += 1 - grid[i][j];
                }
            }

            ones = Math.max(ones, m - ones);

            score += ones * (1 << (n - j - 1));
        }

        return score;
    }
}