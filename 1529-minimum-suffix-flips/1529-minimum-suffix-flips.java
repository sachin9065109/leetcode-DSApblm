class Solution {
    public int minFlips(String target) {

        int flips = 0;

        for (int i = 0; i < target.length(); i++) {

            char current = (flips % 2 == 0) ? '0' : '1';

            if (current != target.charAt(i)) {
                flips++;
            }
        }

        return flips;
    }
}