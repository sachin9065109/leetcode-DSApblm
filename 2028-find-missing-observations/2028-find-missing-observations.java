class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;

        for (int x : rolls) {
            sum += x;
        }

        int totalSum = (rolls.length + n) * mean;
        int missingSum = totalSum - sum;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int[] ans = new int[n];

        Arrays.fill(ans, 1);

        int remaining = missingSum - n;

        for (int i = 0; i < n && remaining > 0; i++) {
            int add = Math.min(5, remaining);
            ans[i] += add;
            remaining -= add;
        }

        return ans;
    }
}