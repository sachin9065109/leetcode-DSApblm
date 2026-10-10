class Solution {
    public int longestPalindrome(String s, String t) {
        int ans = 0;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String a = s.substring(i, j);

                for (int k = 0; k <= t.length(); k++) {
                    for (int l = k; l <= t.length(); l++) {
                        String b = t.substring(k, l);

                        String str = a + b;

                        if (isPalindrome(str)) {
                            ans = Math.max(ans, str.length());
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}