class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = comb(n + 2);

        if (n >= limit + 1) {
            ans -= 3 * comb(n - limit - 1 + 2);
        }

        if (n >= 2 * (limit + 1)) {
            ans += 3 * comb(n - 2 * (limit + 1) + 2);
        }

        if (n >= 3 * (limit + 1)) {
            ans -= comb(n - 3 * (limit + 1) + 2);
        }

        return ans;
    }

    private long comb(long n) {
        return n * (n - 1) / 2;
    }
}