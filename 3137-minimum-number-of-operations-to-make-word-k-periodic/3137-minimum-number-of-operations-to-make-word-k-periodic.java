class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        int maxFreq = 0;

        for (int i = 0; i < word.length(); i += k) {
            String s = word.substring(i, i + k);
            int cnt = map.getOrDefault(s, 0) + 1;
            map.put(s, cnt);
            maxFreq = Math.max(maxFreq, cnt);
        }

        return word.length() / k - maxFreq;
    }
}