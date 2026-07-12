class Solution {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        memo.put(1, 0);

        List<Integer> nums = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            nums.add(i);
        }

        nums.sort((a, b) -> {
            int powerA = getPower(a);
            int powerB = getPower(b);

            if (powerA == powerB) {
                return Integer.compare(a, b);
            }

            return Integer.compare(powerA, powerB);
        });

        return nums.get(k - 1);
    }

    private int getPower(int x) {
        if (memo.containsKey(x)) {
            return memo.get(x);
        }

        int power;

        if (x % 2 == 0) {
            power = 1 + getPower(x / 2);
        } else {
            power = 1 + getPower(3 * x + 1);
        }

        memo.put(x, power);
        return power;
    }
}