
class Solution {

    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;


        TreeSet<Integer> set =
                new TreeSet<>(Collections.reverseOrder());


        for (int r = 0; r < m; r++) {

            for (int c = 0; c < n; c++) {


                set.add(grid[r][c]);


                for (int k = 1;
                     r + 2 * k < m &&
                     c - k >= 0 &&
                     c + k < n;
                     k++) {

                    int sum = 0;



                    for (int i = 0; i <= k; i++) {
                        sum += grid[r + i][c - i];
                    }



                    for (int i = 1; i <= k; i++) {
                        sum += grid[r + i][c + i];
                    }



                    for (int i = 1; i < k; i++) {
                        sum += grid[r + k + i][c - k + i];
                    }

                    
                    
                    for (int i = 1; i < k; i++) {
                        sum += grid[r + k + i][c + k - i];
                    }


                    sum += grid[r + 2 * k][c];

                    set.add(sum);
                }
            }
        }


        int count = Math.min(3, set.size());

        int[] answer = new int[count];

        int index = 0;

        for (int sum : set) {

            answer[index++] = sum;

            if (index == 3) {
                break;
            }
        }

        return answer;
    }
}