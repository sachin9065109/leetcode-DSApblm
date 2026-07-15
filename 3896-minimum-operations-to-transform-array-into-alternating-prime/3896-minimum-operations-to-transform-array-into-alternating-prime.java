class Solution {
    public int minOperations(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int LIMIT = max + 200;
        boolean[] prime = sieve(LIMIT);

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (i % 2 == 0) { 
                while (!prime[val]) {
                    val++;
                    ans++;
                }
            } else { 
                while (prime[val]) {
                    val++;
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                prime[i] = true;
            }

            for (int i = 2; i * i <= n; i++) {
                if (prime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        prime[j] = false;
                    }
                }
            }
        }

        return prime;
    }
}