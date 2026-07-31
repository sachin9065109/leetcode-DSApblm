class Solution {

    private String ans = "";
    private String s;
    private int k;
    private List<Character> chars = new ArrayList<>();

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.s = s;
        this.k = k;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < freq[i] / k; j++) {
                chars.add((char) ('a' + i));
            }
        }

        dfs(new StringBuilder());

        return ans;
    }

    private void dfs(StringBuilder cur) {
        if (cur.length() > ans.length() ||
                (cur.length() == ans.length() && cur.toString().compareTo(ans) > 0)) {
            if (check(cur)) {
                ans = cur.toString();
            }
        }

        if (cur.length() == chars.size()) {
            return;
        }

        boolean[] used = new boolean[26];

        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);

            if (used[c - 'a']) {
                continue;
            }
            used[c - 'a'] = true;

            cur.append(c);

            if (check(cur)) {
                dfs(cur);
            }

            cur.deleteCharAt(cur.length() - 1);
        }
    }

    private boolean check(CharSequence t) {
        int idx = 0;
        int cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == t.charAt(idx)) {
                idx++;
                if (idx == t.length()) {
                    cnt++;
                    if (cnt == k) {
                        return true;
                    }
                    idx = 0;
                }
            }
        }

        return false;
    }
}