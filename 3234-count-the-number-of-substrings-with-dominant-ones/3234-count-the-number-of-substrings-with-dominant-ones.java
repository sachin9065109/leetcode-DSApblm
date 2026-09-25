
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] zero = new int[n];
        int z = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero[z++] = i;
            }
        }

        long ans = 0;

        for (int l = 0; l < n; l++) {
            int first = lowerBound(zero, z, l);

            if (first == z) {
                ans += n - l;
                continue;
            }

            ans += zero[first] - l;

            for (int k = 1; first + k - 1 < z; k++) {
                int lastZero = zero[first + k - 1];
                int nextZero = first + k < z ? zero[first + k] : n;

                long ones = lastZero - l + 1L - k;
                long required = (long) k * k;

                long need = Math.max(0L, required - ones);
                long start = lastZero + need;

                if (start < nextZero) {
                    ans += nextZero - start;
                }

                if ((long) k * k + k > n - l) {
                    break;
                }
            }
        }

        return (int) ans;
    }

    private int lowerBound(int[] arr, int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}