class Solution {
    public int numSpecialEquivGroups(String[] words) {

        Set<String> set = new HashSet<>();

        for (String word : words) {

            List<Character> even = new ArrayList<>();
            List<Character> odd = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                if ((i & 1) == 0) {
                    even.add(word.charAt(i));
                } else {
                    odd.add(word.charAt(i));
                }
            }

            Collections.sort(even);
            Collections.sort(odd);

            StringBuilder sb = new StringBuilder();

            for (char c : even) sb.append(c);
            sb.append('#');
            for (char c : odd) sb.append(c);

            set.add(sb.toString());
        }

        return set.size();
    }
}