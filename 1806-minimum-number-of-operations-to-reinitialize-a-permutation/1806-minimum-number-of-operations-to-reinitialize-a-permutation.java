class Solution {
    public int reinitializePermutation(int n) {
        int operations = 0;
        int pos = 1;

        do {
            if (pos < n / 2) {
                pos = 2 * pos;
            } else {
                pos = 2 * pos - n + 1;
            }
            operations++;
        } while (pos != 1);

        return operations;
    }
}