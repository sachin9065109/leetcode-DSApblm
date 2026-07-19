class Solution {
    public int longestSquareStreak(int[] nums) {
      
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 1;

        for (int num : nums) {
            int root = (int) Math.sqrt(num);

            if (root * root == num && dp.containsKey(root)) {
                dp.put(num, dp.get(root) + 1);
            } else {
                dp.put(num, 1);
            }

            ans = Math.max(ans, dp.get(num));
        }

        return ans >= 2 ? ans : -1;
    }
}
  