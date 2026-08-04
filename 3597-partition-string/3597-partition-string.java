class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();

        int n = s.length();
        int i = 0;

        while (i < n) {
            StringBuilder curr = new StringBuilder();
            int j = i;

            while (j < n) {
                curr.append(s.charAt(j));
                String str = curr.toString();

                if (!seen.contains(str)) {
                    seen.add(str);
                    ans.add(str);
                    break;
                }
                j++;
            }

            if (j == n) break;

            i = j + 1;
        }

        return ans;
    }
}