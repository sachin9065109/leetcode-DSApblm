class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;

            if (canPartition(String.valueOf(square), 0, i)) {
                ans += square;
            }
        }

        return ans;
    }

    private boolean canPartition(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0;
        }

        int value = 0;

        for (int i = index; i < s.length(); i++) {
            value = value * 10 + (s.charAt(i) - '0');

            if (value > target) {
                break;
            }

            if (canPartition(s, i + 1, target - value)) {
                return true;
            }
        }

        return false;
    }
}