class Solution {
    public int findTheWinner(int n, int k) {

        int winner = 0;

        for (int people = 2; people <= n; people++) {
            winner = (winner + k) % people;
        }

        return winner + 1;
    }
}