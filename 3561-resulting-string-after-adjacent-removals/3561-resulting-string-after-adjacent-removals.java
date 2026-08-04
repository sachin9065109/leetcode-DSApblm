class Solution {
    public String resultingString(String s) {
        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = st.length();

            if (len > 0 && isConsecutive(st.charAt(len - 1), c)) {
                st.deleteCharAt(len - 1);
            } else {
                st.append(c);
            }
        }

        return st.toString();
    }

    private boolean isConsecutive(char a, char b) {
        int diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}