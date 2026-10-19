class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (m > n) {
            return 0;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : word2.toCharArray()) {
            need[c - 'a']++;
        }

        long ans = 0;
        int left = 0;
        int matched = 0;

        for (int right = 0; right < n; right++) {
            int c = word1.charAt(right) - 'a';
            window[c]++;

            if (window[c] <= need[c]) {
                matched++;
            }

            while (matched == m) {
                ans += n - right;

                int leftChar = word1.charAt(left) - 'a';
                if (window[leftChar] <= need[leftChar]) {
                    matched--;
                }
                window[leftChar]--;
                left++;
            }
        }

        return ans;
    }
}