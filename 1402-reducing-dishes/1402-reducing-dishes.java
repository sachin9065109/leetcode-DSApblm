class Solution {
    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int suffixSum = 0;
        int ans = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {

            suffixSum += satisfaction[i];

            if (suffixSum <= 0) {
                break;
            }

            ans += suffixSum;
        }

        return ans;
    }
}