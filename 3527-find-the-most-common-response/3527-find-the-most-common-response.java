class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> freq = new HashMap<>();

        for (List<String> day : responses) {
            Set<String> unique = new HashSet<>(day);

            for (String s : unique) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
        }

        String ans = "";
        int maxFreq = 0;

        for (String s : freq.keySet()) {
            int count = freq.get(s);

            if (count > maxFreq || 
                (count == maxFreq && (ans.isEmpty() || s.compareTo(ans) < 0))) {
                maxFreq = count;
                ans = s;
            }
        }

        return ans;
    }
}