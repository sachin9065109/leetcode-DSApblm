class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        int n = word.length();
        int maxLen = n - numFriends + 1;
        String ans = "";

        for (int i = 0; i < n; i++) {
            String sub = word.substring(i, Math.min(n, i + maxLen));

            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }

        return ans;
    }
}