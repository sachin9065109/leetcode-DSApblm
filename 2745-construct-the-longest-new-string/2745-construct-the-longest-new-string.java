class Solution {
    public int longestString(int x, int y, int z) {
        int pairs = Math.min(x, y);
        int used;

        if (x == y) {
            used = x + y + z;
        } else {
            used = 2 * pairs + 1 + z;
        }

        return used * 2;
    }
}