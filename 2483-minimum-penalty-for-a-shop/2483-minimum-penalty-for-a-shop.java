class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length();

        int[] prefixN = new int[n + 1];
        int[] suffixY = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixN[i + 1] = prefixN[i];
            if (customers.charAt(i) == 'N')
                prefixN[i + 1]++;
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1];
            if (customers.charAt(i) == 'Y')
                suffixY[i]++;
        }

        int ans = 0;
        int minPenalty = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            int penalty = prefixN[i] + suffixY[i];

            if (penalty < minPenalty) {
                minPenalty = penalty;
                ans = i;
            }
        }

        return ans;
    }
}