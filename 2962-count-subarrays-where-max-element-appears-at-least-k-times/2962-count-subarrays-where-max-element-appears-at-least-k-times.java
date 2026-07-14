class Solution {

    public long countSubarrays(int[] nums, int k) {

        int max = 0;

        for (int num : nums)
            max = Math.max(max, num);

        int left = 0;
        int countMax = 0;

        long ans = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == max)
                countMax++;

            while (countMax >= k) {

                if (nums[left] == max)
                    countMax--;

                left++;
            }

            ans += left;
        }

        return ans;
    }
}