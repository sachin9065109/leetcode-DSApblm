

class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;

        if (k == 0) {
            return n;
        }

        Arrays.sort(nums);

        int threshold = nums[n - k];

        int answer = 0;

        for (int x : nums) {
            if (x < threshold) {
                answer++;
            }
        }

        return answer;
    }
}