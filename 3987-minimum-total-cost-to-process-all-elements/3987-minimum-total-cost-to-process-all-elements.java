class Solution {
    public int minimumCost(int[] nums, int k) {
        final long MOD = 1_000_000_007L;

        long cur = k;
        long cnt = 0;

        for (int x : nums) {
            if (cur < x) {
                long need = (x - cur + (long) k - 1) / k;
                cnt += need;
                cur += need * (long) k;
            }
            cur -= x;
        }

        cnt %= MOD;
        return (int) (((cnt + 1) * cnt / 2) % MOD);
    }
}