class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        long pairs = 0;
        long ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int x = nums[right];

            int count = freq.getOrDefault(x, 0);
            pairs += count;
            freq.put(x, count + 1);

            while (pairs >= k) {
                ans += n - right;

                int y = nums[left];
                int current = freq.get(y);

                pairs -= current - 1;

                if (current == 1) {
                    freq.remove(y);
                } else {
                    freq.put(y, current - 1);
                }

                left++;
            }
        }

        return ans;
    }
}