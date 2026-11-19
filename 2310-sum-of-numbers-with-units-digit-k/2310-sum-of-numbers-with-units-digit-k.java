class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }

        for (int count = 1; count <= 10; count++) {
            if (count * k <= num &&
                (count * k) % 10 == num % 10) {
                return count;
            }
        }

        return -1;
    }
}