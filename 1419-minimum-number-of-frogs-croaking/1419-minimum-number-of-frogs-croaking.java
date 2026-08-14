class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5];
        int activeFrogs = 0;
        int answer = 0;

        for (char ch : croakOfFrogs.toCharArray()) {
            int index;

            if (ch == 'c') {
                index = 0;
            } else if (ch == 'r') {
                index = 1;
            } else if (ch == 'o') {
                index = 2;
            } else if (ch == 'a') {
                index = 3;
            } else {
                index = 4;
            }

            if (index > 0 && count[index - 1] == 0) {
                return -1;
            }

            count[index]++;

            if (ch == 'c') {
                activeFrogs++;
                answer = Math.max(answer, activeFrogs);
            } else if (ch == 'k') {
                activeFrogs--;
            }

            if (index > 0) {
                count[index - 1]--;
            }
        }

        if (activeFrogs != 0) {
            return -1;
        }

        return answer;
    }
}