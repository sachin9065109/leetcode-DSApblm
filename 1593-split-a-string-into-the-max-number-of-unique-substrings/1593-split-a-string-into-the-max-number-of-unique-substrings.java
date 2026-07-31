class Solution {

    int ans = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<>());
        return ans;
    }

    private void backtrack(String s, int index, HashSet<String> set) {

        if (index == s.length()) {
            ans = Math.max(ans, set.size());
            return;
        }

        if (set.size() + (s.length() - index) <= ans) {
            return;
        }

        for (int end = index + 1; end <= s.length(); end++) {

            String curr = s.substring(index, end);

            if (set.contains(curr)) {
                continue;
            }

            set.add(curr);

            backtrack(s, end, set);

            set.remove(curr);
        }
    }
}