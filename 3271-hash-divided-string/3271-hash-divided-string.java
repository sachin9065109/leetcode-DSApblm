class Solution {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i += k) {
            int sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += s.charAt(j) - 'a';
            }

            ans.append((char) ('a' + (sum % 26)));
        }

        return ans.toString();
    }
}