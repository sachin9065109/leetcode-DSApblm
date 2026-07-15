class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        int moves = 0;

        while (left < right) {
            int k = right;

            while (k > left && arr[k] != arr[left]) {
                k--;
            }

            if (k == left) {
                swap(arr, left, left + 1);
                moves++;
            } else {
                while (k < right) {
                    swap(arr, k, k + 1);
                    moves++;
                    k++;
                }
                left++;
                right--;
            }
        }

        return moves;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}