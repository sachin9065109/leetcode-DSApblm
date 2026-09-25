
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int ax = points[i][0];
            int ay = points[i][1];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int bx = points[j][0];
                int by = points[j][1];

                if (ax > bx || ay < by) {
                    continue;
                }

                boolean valid = true;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    int x = points[k][0];
                    int y = points[k][1];

                    if (x >= ax && x <= bx && y >= by && y <= ay) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans++;
                }
            }
        }

        return ans;
    }
}