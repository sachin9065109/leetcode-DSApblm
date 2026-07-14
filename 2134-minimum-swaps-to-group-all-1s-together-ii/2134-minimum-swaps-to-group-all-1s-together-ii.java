class Solution {

    public int minSwaps(int[] nums) {

        int n = nums.length;

        int ones = 0;

        for (int x : nums)
            ones += x;

        if (ones <= 1)
            return 0;

        int currOnes = 0;
        int maxOnes = 0;

        int left = 0;

        for (int right = 0; right < 2 * n; right++) {

            currOnes += nums[right % n];

            if (right - left + 1 > ones) {
                currOnes -= nums[left % n];
                left++;
            }

            if (right - left + 1 == ones) {
                maxOnes = Math.max(maxOnes, currOnes);
            }
        }

        return ones - maxOnes;
    }
}