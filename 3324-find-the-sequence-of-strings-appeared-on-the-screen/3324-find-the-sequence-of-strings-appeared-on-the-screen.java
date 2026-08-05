class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : target.toCharArray()) {
            // Press Key 1
            sb.append('a');
            ans.add(sb.toString());

            while (sb.charAt(sb.length() - 1) != ch) {
                char last = sb.charAt(sb.length() - 1);
                sb.setCharAt(sb.length() - 1, (char) (last + 1));
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}