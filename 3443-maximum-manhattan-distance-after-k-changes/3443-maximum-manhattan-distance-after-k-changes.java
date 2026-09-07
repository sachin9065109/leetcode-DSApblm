class Solution {
    public int maxDistance(String s, int k) {

        int ans = 0;

       
        int nw = 0;
        int ne = 0;
        int sw = 0;
        int se = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == 'N' || c == 'W') {
                nw++;
            } else {
                nw--;
            }

            if (c == 'N' || c == 'E') {
                ne++;
            } else {
                ne--;
            }

            if (c == 'S' || c == 'W') {
                sw++;
            } else {
                sw--;
            }

            if (c == 'S' || c == 'E') {
                se++;
            } else {
                se--;
            }

            int len = i + 1;

            int best = Math.max(
                Math.max(nw, ne),
                Math.max(sw, se)
            );

            best += 2 * k;

            best = Math.min(best, len);

            ans = Math.max(ans, best);
        }

        return ans;
    }
}