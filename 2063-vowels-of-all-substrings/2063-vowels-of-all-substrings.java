class Solution {

    public long countVowels(String word) {

        int n = word.length();

        long ans = 0;

        for (int i = 0; i < n; i++) {

            char ch = word.charAt(i);

            if (ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u') {

                long left = i + 1;
                long right = n - i;

                ans += left * right;
            }
        }

        return ans;
    }
}