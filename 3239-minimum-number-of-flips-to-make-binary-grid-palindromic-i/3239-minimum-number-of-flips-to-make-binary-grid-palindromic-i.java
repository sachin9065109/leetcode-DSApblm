class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int rowFlips = 0;

        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if (grid[i][l] != grid[i][r]) {
                    rowFlips++;
                }
                l++;
                r--;
            }
        }

        int colFlips = 0;

        for (int j = 0; j < n; j++) {
            int top = 0, bottom = m - 1;
            while (top < bottom) {
                if (grid[top][j] != grid[bottom][j]) {
                    colFlips++;
                }
                top++;
                bottom--;
            }
        }

        return Math.min(rowFlips, colFlips);
    }
}