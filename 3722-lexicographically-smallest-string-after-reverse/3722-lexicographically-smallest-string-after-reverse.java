class Solution {

    public String lexSmallest(String s) {
        String ans = null;
        int n = s.length();

        for (int k = 1; k <= n; k++) {
            char[] arr = s.toCharArray();
            reverse(arr, 0, k - 1);
            String cur = new String(arr);

            if (ans == null || cur.compareTo(ans) < 0) {
                ans = cur;
            }
        }

        for (int k = 1; k <= n; k++) {
            char[] arr = s.toCharArray();
            reverse(arr, n - k, n - 1);
            String cur = new String(arr);

            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
        }

        return ans;
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}