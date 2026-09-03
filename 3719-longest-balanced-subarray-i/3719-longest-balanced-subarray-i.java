class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int l = 0; l < n; l++) {
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            for (int r = l; r < n; r++) {
                if (nums[r] % 2 == 0) {
                    even.add(nums[r]);
                } else {
                    odd.add(nums[r]);
                }

                if (even.size() == odd.size()) {
                    answer = Math.max(answer, r - l + 1);
                }
            }
        }

        return answer;
    }
} 
    