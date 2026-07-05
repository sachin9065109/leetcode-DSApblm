class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            if (first == -1 || first == last)
                continue;

            HashSet<Character> set = new HashSet<>();

            for (int i = first + 1; i < last; i++) {
                set.add(s.charAt(i));
            }

            ans += set.size();
        }

        return ans;
    }
}