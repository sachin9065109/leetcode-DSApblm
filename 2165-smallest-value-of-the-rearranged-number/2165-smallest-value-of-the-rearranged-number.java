
class Solution {
    public long smallestNumber(long num) {

        if (num == 0) {
            return 0;
        }

        boolean negative = num < 0;

        num = Math.abs(num);

        int[] freq = new int[10];

        while (num > 0) {
            int digit = (int)(num % 10);
            freq[digit]++;
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();

        if (negative) {

           
            for (int digit = 9; digit >= 0; digit--) {
                while (freq[digit] > 0) {
                    sb.append(digit);
                    freq[digit]--;
                }
            }

            return -Long.parseLong(sb.toString());

        } else {

         
            for (int digit = 1; digit <= 9; digit++) {
                if (freq[digit] > 0) {
                    sb.append(digit);
                    freq[digit]--;
                    break;
                }
            }

            for (int digit = 0; digit <= 9; digit++) {
                while (freq[digit] > 0) {
                    sb.append(digit);
                    freq[digit]--;
                }
            }

            return Long.parseLong(sb.toString());
        }
    }
}