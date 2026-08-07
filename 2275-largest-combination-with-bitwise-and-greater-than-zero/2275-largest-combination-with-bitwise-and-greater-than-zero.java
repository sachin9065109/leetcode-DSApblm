class Solution {
    public int largestCombination(int[] candidates) {
        int ans = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}