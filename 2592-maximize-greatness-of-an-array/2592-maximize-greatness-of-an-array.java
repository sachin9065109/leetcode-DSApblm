class Solution {
    public int maximizeGreatness(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {

            if (nums[j] > nums[i]) {
                ans++;
                i++;
            }

            j++;
        }

        return ans;
    }
}