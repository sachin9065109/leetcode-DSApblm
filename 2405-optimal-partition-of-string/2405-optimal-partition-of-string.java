class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 1;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                ans++;
                set.clear();
            }

            set.add(c);
        }

        return ans;
    }
}
