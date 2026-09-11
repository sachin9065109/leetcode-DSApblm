class Solution {
    public long countPairs(int[] nums, int k) {
        HashMap<Integer, Long> map = new HashMap<>();
        long ans = 0;

        for (int num : nums) {
            int g = gcd(num, k);

            for (Map.Entry<Integer, Long> entry : map.entrySet()) {
                int prevGcd = entry.getKey();

                if ((long) prevGcd * g % k == 0) {
                    ans += entry.getValue();
                }
            }

            map.put(g, map.getOrDefault(g, 0L) + 1);
        }

        return ans;
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