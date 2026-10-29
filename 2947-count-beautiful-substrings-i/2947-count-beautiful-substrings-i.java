
class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int vowels = 0;
            int consonants = 0;

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);

                if (c == 'a' || c == 'e' || c == 'i'
                        || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }

                if (vowels == consonants
                        && (vowels * consonants) % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
