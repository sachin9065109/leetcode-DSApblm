class Solution {

    int m, n;
    boolean[][] vis;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int countIslands(int[][] grid, int k) {

        m = grid.length;
        n = grid[0].length;

        vis = new boolean[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] > 0 && !vis[i][j]) {

                    long sum = dfs(grid, i, j);

                    if (sum % k == 0)
                        ans++;
                }
            }
        }

        return ans;
    }

    private long dfs(int[][] grid, int r, int c) {

        vis[r][c] = true;

        long sum = grid[r][c];

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if (vis[nr][nc] || grid[nr][nc] == 0)
                continue;

            sum += dfs(grid, nr, nc);
        }

        return sum;
    }
}