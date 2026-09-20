class Solution {
    public int sumOfPrimesInRange(int n) {
        int r = reverse(n);

        int left = Math.min(n, r);
        int right = Math.max(n, r);

        int sum = 0;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    private int reverse(int n) {
        int rev = 0;

        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return rev;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}