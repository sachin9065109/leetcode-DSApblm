class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] value = new int[26];

        for (int i = 0; i < 26; i++) {
            value[i] = i + 1;
        }

        for (int i = 0; i < chars.length(); i++) {
            value[chars.charAt(i) - 'a'] = vals[i];
        }

        int current = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int x = value[s.charAt(i) - 'a'];

            current += x;

            if (current < 0) {
                current = 0;
            }

            ans = Math.max(ans, current);
        }

        return ans;
    }
}