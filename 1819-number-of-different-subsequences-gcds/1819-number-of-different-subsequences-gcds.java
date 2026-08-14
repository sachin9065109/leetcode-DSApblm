class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxValue = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        boolean[] present = new boolean[maxValue + 1];

        for (int num : nums) {
            present[num] = true;
        }

        int answer = 0;

        for (int g = 1; g <= maxValue; g++) {
            int currentGcd = 0;

            for (int multiple = g; multiple <= maxValue; multiple += g) {
                if (!present[multiple]) {
                    continue;
                }

                currentGcd = gcd(currentGcd, multiple);

                if (currentGcd == g) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}