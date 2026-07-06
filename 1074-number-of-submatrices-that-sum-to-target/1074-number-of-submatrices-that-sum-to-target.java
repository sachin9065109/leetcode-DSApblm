class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int ans = 0;

        for (int left = 0; left < n; left++) {

            for (int right = left; right < n; right++) {

                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int currSum = 0;

                for (int row = 0; row < m; row++) {

                    int rowSum = matrix[row][right];

                    if (left > 0)
                        rowSum -= matrix[row][left - 1];

                    currSum += rowSum;

                    ans += map.getOrDefault(currSum - target, 0);

                    map.put(currSum,
                            map.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return ans;
    }
}