class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;

        for (String s : nums) {
            if (!target.startsWith(s)) {
                continue;
            }

            String rem = target.substring(s.length());

            ans += map.getOrDefault(rem, 0);

            if (s.equals(rem)) {
                ans--;
            }
        }

        return ans;
    }
}