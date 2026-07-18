class Solution {

    public boolean primeSubOperation(int[] nums) {

        List<Integer> primes = getPrimes(1000);

        int prev = 0;

        for (int i = 0; i < nums.length; i++) {

            int bestPrime = 0;

            for (int p : primes) {
                if (p >= nums[i])
                    break;

                if (nums[i] - p > prev)
                    bestPrime = p;
            }

            nums[i] -= bestPrime;

            if (nums[i] <= prev)
                return false;

            prev = nums[i];
        }

        return true;
    }

    private List<Integer> getPrimes(int limit) {

        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        return primes;
    }
}