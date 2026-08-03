class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder ans = new StringBuilder();

        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();

        while (i < n && j < m) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                ans.append(word1.charAt(i++));
            } else {
                ans.append(word2.charAt(j++));
            }
        }

        while (i < n) ans.append(word1.charAt(i++));
        while (j < m) ans.append(word2.charAt(j++));

        return ans.toString();
    }
}