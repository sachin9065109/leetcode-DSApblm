class Solution {
    public long sumOfLargestPrimes(String s) {
        Set<Long> primes = new HashSet<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            long num = 0;

            for (int j = i; j < n; j++) {
                num = num * 10 + (s.charAt(j) - '0');

                if (isPrime(num)) {
                    primes.add(num);
                }
            }
        }

        List<Long> list = new ArrayList<>(primes);
        list.sort(Collections.reverseOrder());

        long sum = 0;

        for (int i = 0; i < Math.min(3, list.size()); i++) {
            sum += list.get(i);
        }

        return sum;
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}