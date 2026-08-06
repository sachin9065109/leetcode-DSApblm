class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int mid = n / 2;

        int[] y = new int[3];
        int[] other = new int[3];
        int yCells = 0;
        int otherCells = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isY = false;

                if (i <= mid) {
                    if (j == i || j == n - 1 - i) {
                        isY = true;
                    }
                } else {
                    if (j == mid) {
                        isY = true;
                    }
                }

                if (isY) {
                    y[grid[i][j]]++;
                    yCells++;
                } else {
                    other[grid[i][j]]++;
                    otherCells++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (a == b) {
                    continue;
                }

                int cost = (yCells - y[a]) + (otherCells - other[b]);
                ans = Math.min(ans, cost);
            }
        }

        return ans;
    }
}