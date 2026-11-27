class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);

        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0) {
                int j = stack[top];

                if (cars[i][1] <= cars[j][1]) {
                    top--;
                    continue;
                }

                double time = (double) (cars[j][0] - cars[i][0])
                        / (cars[i][1] - cars[j][1]);

                if (ans[j] == -1 || time <= ans[j]) {
                    ans[i] = time;
                    break;
                }

                top--;
            }

            stack[++top] = i;
        }

        return ans;
    }
}