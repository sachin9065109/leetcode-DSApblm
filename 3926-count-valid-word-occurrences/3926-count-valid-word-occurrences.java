class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder s = new StringBuilder();

        for (String chunk : chunks) {
            s.append(chunk);
        }

        Map<String, Integer> map = new HashMap<>();

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                word.append(c);
            } 
            else if (c == '-') {
                boolean left = i > 0 && isLetter(s.charAt(i - 1));
                boolean right = i + 1 < s.length() && isLetter(s.charAt(i + 1));

                if (left && right) {
                    word.append('-');
                } else {
                    addWord(map, word);
                    word.setLength(0);
                }
            } 
            else {
                addWord(map, word);
                word.setLength(0);
            }
        }

        addWord(map, word);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private void addWord(Map<String, Integer> map, StringBuilder word) {
        if (word.length() > 0) {
            String w = word.toString();
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
    }
}