class Solution {

    public boolean canConstruct(String s, int k) {

        if (k > s.length())
            return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;

        for (int f : freq) {
            if ((f & 1) == 1)
                odd++;
        }

        return odd <= k;
    }
}