class Solution {

    public int minAnagramLength(String s) {
        int n = s.length();

        for (int len = 1; len <= n; len++) {
            if (n % len != 0)
                continue;

            if (check(s, len))
                return len;
        }

        return n;
    }

    private boolean check(String s, int len) {
        int[] base = new int[26];

        for (int i = 0; i < len; i++) {
            base[s.charAt(i) - 'a']++;
        }

        for (int start = len; start < s.length(); start += len) {
            int[] freq = new int[26];

            for (int i = start; i < start + len; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            if (!Arrays.equals(base, freq))
                return false;
        }

        return true;
    }
}