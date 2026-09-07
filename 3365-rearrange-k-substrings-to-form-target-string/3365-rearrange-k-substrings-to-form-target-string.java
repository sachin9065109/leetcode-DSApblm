class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {

        int n = s.length();

        int len = n / k;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i += len) {

            String block = s.substring(i, i + len);

            map.put(block, map.getOrDefault(block, 0) + 1);
        }

        for (int i = 0; i < n; i += len) {

            String block = t.substring(i, i + len);

            if (map.getOrDefault(block, 0) == 0) {
                return false;
            }

            map.put(block, map.get(block) - 1);
        }

        return true;
    }
}