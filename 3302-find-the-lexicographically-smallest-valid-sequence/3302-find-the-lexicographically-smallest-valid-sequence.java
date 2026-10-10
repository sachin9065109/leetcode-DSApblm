
class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[n + 1];
        int j = m - 1;

       
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        j = 0;
        boolean mismatchUsed = false;

        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (!mismatchUsed &&
                       suffix[i + 1] >= m - j - 1) {
                ans[j++] = i;
                mismatchUsed = true;
            }
        }

        return j == m ? ans : new int[0];
    }
}