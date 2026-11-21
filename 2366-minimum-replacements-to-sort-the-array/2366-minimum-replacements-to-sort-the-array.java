class Solution {
    public long minimumReplacement(int[] nums) {
        long operations = 0;
        long prev = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= prev) {
                prev = nums[i];
            } else {
                long parts = (nums[i] + prev - 1) / prev;
                operations += parts - 1;
                prev = nums[i] / parts;
            }
        }

        return operations;
    }
}