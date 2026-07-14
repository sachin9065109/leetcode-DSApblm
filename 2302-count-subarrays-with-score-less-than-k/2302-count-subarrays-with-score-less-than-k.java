class Solution {

    public long countSubarrays(int[] nums, long k) {

        long sum = 0;
        long ans = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum * (right - left + 1L) >= k) {
                sum -= nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}