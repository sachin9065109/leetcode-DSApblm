class Solution {
    public int numSplits(String s) {
        int n = s.length();

        int[] suffix = new int[n];

        int[] freq = new int[26];

        int distinct = 0;

        for (int i = n - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';

            if (freq[idx] == 0) {
                distinct++;
            }

            freq[idx]++;
            suffix[i] = distinct;
        }

        int[] leftFreq = new int[26];
        int distinctLeft = 0;
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {

            int idx = s.charAt(i) - 'a';

            if (leftFreq[idx] == 0) {
                distinctLeft++;
            }

            leftFreq[idx]++;

            int distinctRight = suffix[i + 1];

            if (distinctLeft == distinctRight) {
                answer++;
            }
        }

        return answer;
    }
}