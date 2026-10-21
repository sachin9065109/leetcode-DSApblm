class Solution {
    public int maximumSum(int[] nums) {
        int[] max = new int[82];
        int result = -1;

        for (int num : nums) {
            int sum = 0;
            int temp = num;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (max[sum] != 0) {
                result = Math.max(result, max[sum] + num);
            }

            max[sum] = Math.max(max[sum], num);
        }

        return result;
    }
}