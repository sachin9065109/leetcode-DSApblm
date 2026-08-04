class Solution {
    public int scoreDifference(int[] nums) {

        int first = 0;
        int second = 0;

        boolean firstActive = true;

        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] & 1) == 1) {
                firstActive = !firstActive;
            }

            if (i % 6 == 5) {
                firstActive = !firstActive;
            }

            if (firstActive) {
                first += nums[i];
            } else {
                second += nums[i];
            }
        }

        return first - second;
    }
}