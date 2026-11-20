class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long x = 0;
        long place = 1;

        while (digitSum(n) > target) {
            long digit = (n / place) % 10;
            long add = (10 - digit) % 10;
            x += add * place;
            n += add * place;
            place *= 10;
        }

        return x;
    }

    private int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}