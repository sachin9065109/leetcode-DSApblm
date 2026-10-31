
class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];

        for (char c : s.toCharArray()) {
            int curr = c - 'a';
            int max = 0;

            for (int j = Math.max(0, curr - k);
                 j <= Math.min(25, curr + k); j++) {
                max = Math.max(max, dp[j]);
            }

            dp[curr] = max + 1;
        }

        int ans = 0;

        for (int x : dp) {
            ans = Math.max(ans, x);
        }

        return ans;
    }
}
