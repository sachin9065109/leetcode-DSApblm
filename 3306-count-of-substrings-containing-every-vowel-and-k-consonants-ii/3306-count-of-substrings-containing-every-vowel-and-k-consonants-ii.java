class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtMost(word, k) - countAtMost(word, k - 1);
    }

    private long countAtMost(String word, int k) {
        if (k < 0) {
            return 0;
        }

        int n = word.length();
        int left = 0;
        int consonants = 0;
        int[] last = {-1, -1, -1, -1, -1};
        long ans = 0;

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            int vowel = vowelIndex(c);

            if (vowel != -1) {
                last[vowel] = right;
            } else {
                consonants++;
            }

            while (consonants > k) {
                char ch = word.charAt(left++);
                if (vowelIndex(ch) == -1) {
                    consonants--;
                }
            }

            int minLast = n;
            for (int pos : last) {
                minLast = Math.min(minLast, pos);
            }

            if (minLast >= left) {
                ans += minLast - left + 1;
            }
        }

        return ans;
    }

    private int vowelIndex(char c) {
        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
}