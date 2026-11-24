class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] answer = new long[queries.length];

        int halfLength = (intLength + 1) / 2;

        long start = (long) Math.pow(10, halfLength - 1);
        long limit = (long) Math.pow(10, halfLength);

        for (int i = 0; i < queries.length; i++) {
            long prefix = start + queries[i] - 1;

            if (prefix >= limit) {
                answer[i] = -1;
                continue;
            }

            String left = String.valueOf(prefix);

            String right = new StringBuilder(
                left.substring(0, intLength % 2 == 0
                    ? left.length()
                    : left.length() - 1)
            ).reverse().toString();

            answer[i] = Long.parseLong(left + right);
        }

        return answer;
    }
}