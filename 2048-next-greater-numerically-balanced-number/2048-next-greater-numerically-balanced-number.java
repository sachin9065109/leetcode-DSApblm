class Solution {
    public int nextBeautifulNumber(int n) {
        n++;

        while (true) {
            if (isBalanced(n)) {
                return n;
            }
            n++;
        }
    }

    private boolean isBalanced(int n) {
        int[] freq = new int[10];

        while (n > 0) {
            int digit = n % 10;
            freq[digit]++;
            n /= 10;
        }

        for (int d = 0; d <= 9; d++) {
            if (freq[d] != 0 && freq[d] != d) {
                return false;
            }
        }

        return true;
    }
}