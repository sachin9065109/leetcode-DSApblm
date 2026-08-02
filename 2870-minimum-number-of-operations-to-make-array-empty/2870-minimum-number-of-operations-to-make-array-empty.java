class Solution {
    public int minOperations(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (int freq : map.values()) {

            if (freq == 1) {
                return -1;
            }

            ans += (freq + 2) / 3;
        }

        return ans;
    }
}