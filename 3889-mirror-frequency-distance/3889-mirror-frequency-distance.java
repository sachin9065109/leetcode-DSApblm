class Solution {
    public int mirrorFrequency(String s) {

        int[] freq = new int[36];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            } else {
                freq[26 + (c - '0')]++;
            }
        }

        int ans = 0;

        for (int i = 0; i < 13; i++) {
            ans += Math.abs(freq[i] - freq[25 - i]);
        }

        for (int i = 0; i < 5; i++) {
            ans += Math.abs(freq[26 + i] - freq[26 + (9 - i)]);
        }

        return ans;
    }
}