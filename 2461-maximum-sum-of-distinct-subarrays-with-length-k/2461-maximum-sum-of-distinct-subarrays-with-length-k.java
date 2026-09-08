class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                int x = nums[i - k];
                sum -= x;

                map.put(x, map.get(x) - 1);

                if (map.get(x) == 0) {
                    map.remove(x);
                }
            }

            if (i >= k - 1 && map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}