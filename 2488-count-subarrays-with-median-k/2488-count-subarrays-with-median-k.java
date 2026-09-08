class Solution {
    public int countSubarrays(int[] nums, int k) {
         int n = nums.length;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                pos = i;
                break;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int balance = 0;

        map.put(0, 1);

        for (int i = pos - 1; i >= 0; i--) {
            if (nums[i] > k) {
                balance++;
            } else {
                balance--;
            }

            map.put(balance, map.getOrDefault(balance, 0) + 1);
        }

        int ans = 0;
        balance = 0;

        for (int i = pos; i < n; i++) {
            if (nums[i] > k) {
                balance++;
            } else if (nums[i] < k) {
                balance--;
            }

            ans += map.getOrDefault(-balance, 0);
            ans += map.getOrDefault(1 - balance, 0);
        }

        return ans;
    }
}
    