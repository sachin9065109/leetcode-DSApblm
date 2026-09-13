class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;

        int current = 0;
        int wins = 0;

        for (int i = 1; i < n; i++) {
            if (skills[current] > skills[i]) {
                wins++;
            } else {
                current = i;
                wins = 1;
            }

            if (wins == k) {
                return current;
            }
        }

        return current;
    }
}