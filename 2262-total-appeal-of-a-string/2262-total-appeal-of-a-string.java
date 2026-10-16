class Solution {
    public long appealSum(String s) {
        int n = s.length();
        int[] last = new int[26];
        java.util.Arrays.fill(last, -1);

        long current = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            current += i - last[c];
            total += current;

            last[c] = i;
        }

        return total;
    }
}