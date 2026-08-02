class Solution {
    public boolean winnerOfGame(String colors) {

        int alice = 0;
        int bob = 0;

        int i = 0;
        int n = colors.length();

        while (i < n) {

            char ch = colors.charAt(i);
            int j = i;

            while (j < n && colors.charAt(j) == ch) {
                j++;
            }

            int len = j - i;

            if (len >= 3) {
                if (ch == 'A') {
                    alice += len - 2;
                } else {
                    bob += len - 2;
                }
            }

            i = j;
        }

        return alice > bob;
    }
}