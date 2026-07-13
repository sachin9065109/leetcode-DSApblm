class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int longestT = solve(answerKey, k, 'T');
        int longestF = solve(answerKey, k, 'F');

        return Math.max(longestT, longestF);
    }

    public int solve(String s, int k, char target) {

        int left = 0;
        int change = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) != target) {
                change++;
            }

            while (change > k) {

                if (s.charAt(left) != target) {
                    change--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}