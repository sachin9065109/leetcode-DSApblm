class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);

        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int x = 2; x <= n / 2; x++) {
            int y = n - x;

            if (isPrime[x] && isPrime[y]) {
                result.add(Arrays.asList(x, y));
            }
        }

        return result;
    }
}