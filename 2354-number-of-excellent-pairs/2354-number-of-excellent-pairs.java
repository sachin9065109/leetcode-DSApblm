class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        long[] freq = new long[31];

        for (int num : set) {
            int bits = Integer.bitCount(num);
            freq[bits]++;
        }

        long ans = 0;

        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                if (i + j >= k) {
                    ans += freq[i] * freq[j];
                }
            }
        }

        return ans;
    }
}