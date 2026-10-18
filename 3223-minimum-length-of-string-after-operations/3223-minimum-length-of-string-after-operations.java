class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        for (int count : freq) {
            if (count == 0) continue;
            if (count <= 2) {
                ans += count;
            } else {
                ans += 2 - (count % 2);
            }
        }

        return ans;
    }
}