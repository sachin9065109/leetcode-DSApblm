class Solution {

    public int maximumLength(String s) {

        int[][] count = new int[26][51];

        int n = s.length();

        int i = 0;

        while (i < n) {

            char ch = s.charAt(i);

            int j = i;

            while (j < n && s.charAt(j) == ch) {
                j++;
            }

            int runLength = j - i;

            for (int len = 1; len <= runLength; len++) {

                count[ch - 'a'][len] += runLength - len + 1;
            }

            i = j;
        }

        for (int len = 50; len >= 1; len--) {

            for (int c = 0; c < 26; c++) {

                if (count[c][len] >= 3)
                    return len;
            }
        }

        return -1;
    }
}