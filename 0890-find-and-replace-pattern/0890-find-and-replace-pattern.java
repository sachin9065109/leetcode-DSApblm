class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> pToW = new HashMap<>();
        Map<Character, Character> wToP = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (pToW.containsKey(p)) {
                if (pToW.get(p) != w) {
                    return false;
                }
            } else {
                pToW.put(p, w);
            }

            if (wToP.containsKey(w)) {
                if (wToP.get(w) != p) {
                    return false;
                }
            } else {
                wToP.put(w, p);
            }
        }

        return true;
    }
}