class Solution {
    public boolean completePrime(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        for (int i = 1; i <= n; i++) {
            int prefix = Integer.parseInt(s.substring(0, i));
            int suffix = Integer.parseInt(s.substring(n - i));

            if (!isPrime(prefix) || !isPrime(suffix)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= n / i; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}