class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        int ans = 0;

        for (List<Integer> positions : map.values()) {
            int left = 0;

            for (int right = 0; right < positions.size(); right++) {
                while (positions.get(right) - positions.get(left)
                        - (right - left) > k) {
                    left++;
                }

                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}