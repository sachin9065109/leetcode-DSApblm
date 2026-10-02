class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int size = m * n;
        int[] arr = new int[size];

        int k = 0;
        int remainder = grid[0][0] % x;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != remainder) {
                    return -1;
                }

                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int median = arr[size / 2];

        long operations = 0;

        for (int value : arr) {
            operations += Math.abs(value - median) / x;
        }

        return (int) operations;
    }
}