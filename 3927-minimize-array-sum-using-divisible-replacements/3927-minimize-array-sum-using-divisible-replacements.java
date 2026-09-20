class Solution {
    public long minArraySum(int[] nums) {
        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        boolean[] present = new boolean[max + 1];

        for (int x : nums) {
            present[x] = true;
        }

        int[] smallest = new int[max + 1];

        for (int d = 1; d <= max; d++) {
            if (!present[d]) continue;

            for (int multiple = d; multiple <= max; multiple += d) {
                if (smallest[multiple] == 0) {
                    smallest[multiple] = d;
                }
            }
        }

        long sum = 0;

        for (int x : nums) {
            sum += smallest[x];
        }

        return sum;
    }
}