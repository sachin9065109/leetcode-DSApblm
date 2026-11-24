class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;

        for (int len = 1; count < n; len++) {
            int halfLen = (len + 1) / 2;
            long start = pow10(halfLen - 1);
            long end = pow10(halfLen);

            for (long first = start; first < end && count < n; first++) {
                long num = makePalindrome(first, len % 2 == 1);

                if (isPalindromeInBase(num, k)) {
                    sum += num;
                    count++;
                }
            }
        }

        return sum;
    }

    private long makePalindrome(long first, boolean oddLength) {
        long result = first;
        long x = oddLength ? first / 10 : first;

        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }

    private boolean isPalindromeInBase(long num, int base) {
        int[] digits = new int[64];
        int len = 0;

        while (num > 0) {
            digits[len++] = (int) (num % base);
            num /= base;
        }

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            if (digits[i] != digits[j]) {
                return false;
            }
        }

        return true;
    }

    private long pow10(int n) {
        long result = 1;

        while (n-- > 0) {
            result *= 10;
        }

        return result;
    }
}