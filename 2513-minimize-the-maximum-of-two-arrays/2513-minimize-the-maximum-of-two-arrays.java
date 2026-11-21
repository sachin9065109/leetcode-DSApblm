class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long left = 1;
        long right = 2000000000L;

        long d1 = divisor1;
        long d2 = divisor2;
        long c1 = uniqueCnt1;
        long c2 = uniqueCnt2;

        long lcm = d1 / gcd(d1, d2) * d2;

        while (left < right) {
            long mid = left + (right - left) / 2;

            long notDiv1 = mid - mid / d1;
            long notDiv2 = mid - mid / d2;
            long notDivBoth = mid - mid / lcm;

            boolean possible =
                    notDiv1 >= c1 &&
                    notDiv2 >= c2 &&
                    notDivBoth >= c1 + c2;

            if (possible) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}