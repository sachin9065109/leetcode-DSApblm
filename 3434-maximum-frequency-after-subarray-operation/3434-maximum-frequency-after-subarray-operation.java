class Solution {
    public int maxFrequency(int[] nums, int k) {
        int base = 0;
        int ans = 0;

        for (int num : nums) {
            if (num == k) {
                base++;
            }
        }

        for (int v = 1; v <= 50; v++) {
            if (v == k) {
                continue;
            }

            int curr = 0;
            int maxGain = 0;

            for (int num : nums) {
                if (num == v) {
                    curr++;
                } else if (num == k) {
                    curr--;
                }

                curr = Math.max(0, curr);
                maxGain = Math.max(maxGain, curr);
            }

            ans = Math.max(ans, maxGain);
        }

        return base + ans;
    }
}
