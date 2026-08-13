class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[5];
        int[] first = new int[5];

        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = getIndex(c);

            if (idx != -1) {
                freq[idx]++;

                if (first[idx] == -1) {
                    first[idx] = i;
                }
            }
        }

        List<Integer> vowels = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (freq[i] > 0) {
                vowels.add(i);
            }
        }

        Collections.sort(vowels, (a, b) -> {
            if (freq[a] != freq[b]) {
                return Integer.compare(freq[b], freq[a]);
            }

            return Integer.compare(first[a], first[b]);
        });

        char[] result = s.toCharArray();
        int j = 0;

        for (int i = 0; i < result.length; i++) {
            if (getIndex(result[i]) != -1) {
                int vowelIndex = vowels.get(j);
                result[i] = getVowel(vowelIndex);

                freq[vowelIndex]--;

                if (freq[vowelIndex] == 0) {
                    j++;
                }
            }
        }

        return new String(result);
    }

    private int getIndex(char c) {
        if (c == 'a') return 0;
        if (c == 'e') return 1;
        if (c == 'i') return 2;
        if (c == 'o') return 3;
        if (c == 'u') return 4;

        return -1;
    }

    private char getVowel(int index) {
        return "aeiou".charAt(index);
    }
}