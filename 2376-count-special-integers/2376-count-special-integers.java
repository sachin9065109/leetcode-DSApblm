class Solution {
    public int countSpecialNumbers(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        int ans = 0;

        int perm = 9;

        for (int i = 1; i < len; i++) {
            ans += perm;
            perm *= (10 - i);
        }

        boolean[] used = new boolean[10];

        for (int i = 0; i < len; i++) {
            int current = digits[i] - '0';

            for (int d = (i == 0 ? 1 : 0); d < current; d++) {
                if (!used[d]) {
                    int remaining = len - i - 1;
                    int ways = 1;

                    for (int j = 0; j < remaining; j++) {
                        ways *= (9 - i - j);
                    }

                    ans += ways;
                }
            }

            if (used[current]) {
                return ans;
            }

            used[current] = true;
        }

        return ans + 1;
    }
}