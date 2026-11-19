class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long ans = 0;
        long next = 1;

        for (int num : nums) {
            if (next > (long) num) {
                continue;
            }

            long count = (long) num - next;

            if (count >= k) {
                ans += sum(next, next + k - 1);
                return ans;
            }

            ans += sum(next, num - 1);
            k -= count;
            next = (long) num + 1;
        }

        if (k > 0) {
            ans += sum(next, next + k - 1);
        }

        return ans;
    }

    private long sum(long first, long last) {
        return (first + last) * (last - first + 1) / 2;
    }
}