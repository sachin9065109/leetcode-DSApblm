class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] vowels = new int[5];
            int consonants = 0;
            int vowelCount = 0;

            for (int j = i; j < n; j++) {
                char c = word.charAt(j);

                int idx = getVowelIndex(c);

                if (idx != -1) {
                    if (vowels[idx] == 0) {
                        vowelCount++;
                    }
                    vowels[idx]++;
                } else {
                    consonants++;
                }

                if (consonants > k) {
                    break;
                }

                if (vowelCount == 5 && consonants == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private int getVowelIndex(char c) {
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