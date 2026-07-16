class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        int target = countVowels(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (countVowels(words[i]) == target) {
                words[i] = reverse(words[i]);
            }
        }

        return String.join(" ", words);
    }

    private int countVowels(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (isVowel(c)) count++;
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}