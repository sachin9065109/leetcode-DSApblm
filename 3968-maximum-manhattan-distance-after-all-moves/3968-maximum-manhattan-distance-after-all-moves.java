class Solution {
    public int maxDistance(String moves) {
        int x = 0;
        int y = 0;
        int blank = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x--;
            } else if (c == 'R') {
                x++;
            } else {
                blank++;
            }
        }

        int ans = 0;

        ans = Math.max(ans, x + y + blank);
        ans = Math.max(ans, x - y + blank);
        ans = Math.max(ans, -x + y + blank);
        ans = Math.max(ans, -x - y + blank);

        return ans;
    }
}