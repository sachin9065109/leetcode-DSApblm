class Solution {

    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        for (int size = Math.min(m, n); size >= 2; size--) {

            for (int i = 0; i + size <= m; i++) {

                for (int j = 0; j + size <= n; j++) {

                    if (isMagic(grid, row, col, i, j, size))
                        return size;
                }
            }
        }

        return 1;
    }

    private boolean isMagic(int[][] grid, int[][] row, int[][] col,
                            int r, int c, int size) {

        int target = 0;

        for (int i = 0; i < size; i++)
            target += grid[r + i][c + i];

        int diag = 0;

        for (int i = 0; i < size; i++)
            diag += grid[r + i][c + size - 1 - i];

        if (diag != target)
            return false;

        for (int i = 0; i < size; i++) {

            int rowSum = row[r + i][c + size] - row[r + i][c];

            if (rowSum != target)
                return false;
        }

        for (int j = 0; j < size; j++) {

            int colSum = col[r + size][c + j] - col[r][c + j];

            if (colSum != target)
                return false;
        }

        return true;
    }
}