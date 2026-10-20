class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1 << 10];
        count[0] = 1;

        int mask = 0;
        long ans = 0;

        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');

            ans += count[mask];

            for (int i = 0; i < 10; i++) {
                ans += count[mask ^ (1 << i)];
            }

            count[mask]++;
        }

        return ans;
    }
}