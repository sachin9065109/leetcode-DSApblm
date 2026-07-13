class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] freq = new int[26];

        for (char ch : letters)
            freq[ch - 'a']++;

        return dfs(words, score, freq, 0);
    }

    private int dfs(String[] words, int[] score, int[] freq, int idx) {

        if (idx == words.length)
            return 0;

        int notTake = dfs(words, score, freq, idx + 1);

        String word = words[idx];
        int wordScore = 0;
        boolean canTake = true;

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0)
                canTake = false;

            wordScore += score[ch - 'a'];
        }

        int take = 0;

        if (canTake) {
            take = wordScore + dfs(words, score, freq, idx + 1);
        }

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        return Math.max(take, notTake);
    }
}