class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();

        int xor = 0;
        long ans = 0;

        map.put(0, 1L);

        for (int x : nums) {
            xor ^= x;

            if (map.containsKey(xor)) {
                ans += map.get(xor);
            }

            map.put(xor, map.getOrDefault(xor, 0L) + 1);
        }

        return ans;
    }
}