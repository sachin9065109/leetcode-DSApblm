class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            char c = str1.charAt(i);
            char next = (char) ((c - 'a' + 1) % 26 + 'a');

            if (c == str2.charAt(j) || next == str2.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == str2.length();
    }
}