class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int n = words.length;
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            freq[i] = getFreq(words[i]);
        }

        Arrays.sort(freq);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int f = getFreq(queries[i]);

            int idx = upperBound(freq, f);

            ans[i] = n - idx;
        }

        return ans;
    }

    private int getFreq(String s) {
        char smallest = 'z';
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch < smallest) {
                smallest = ch;
                count = 1;
            } else if (ch == smallest) {
                count++;
            }
        }

        return count;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}