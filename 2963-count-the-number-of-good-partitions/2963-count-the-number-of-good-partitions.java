class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int mod = 1_000_000_007;
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            last.put(nums[i], i);
        }

        long ans = 1;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, last.get(nums[i]));

            if (i == end && i < nums.length - 1) {
                ans = (ans * 2) % mod;
            }
        }

        return (int) ans;
    }
}
