class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        java.util.Arrays.fill(isPrime, true);

        if (right >= 0) isPrime[0] = false;
        if (right >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int prev = -1;
        int num1 = -1;
        int num2 = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prev != -1 && i - prev < minDiff) {
                    minDiff = i - prev;
                    num1 = prev;
                    num2 = i;
                }

                prev = i;
            }
        }

        return new int[]{num1, num2};
    }
}