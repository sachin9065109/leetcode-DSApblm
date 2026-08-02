class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int ans = 0;

        int r = startPos[0];
        int c = startPos[1];

        while (r < homePos[0]) {
            r++;
            ans += rowCosts[r];
        }

        while (r > homePos[0]) {
            r--;
            ans += rowCosts[r];
        }

        while (c < homePos[1]) {
            c++;
            ans += colCosts[c];
        }

        while (c > homePos[1]) {
            c--;
            ans += colCosts[c];
        }

        return ans;
    }
}