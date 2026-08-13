class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int a = 1; a <= 1000; a++) {
            long a3 = (long) a * a * a;

            if (a3 > n) {
                break;
            }

            for (int b = a; b <= 1000; b++) {
                long b3 = (long) b * b * b;
                long sum = a3 + b3;

                if (sum > n) {
                    break;
                }

                int value = (int) sum;
                count.put(value, count.getOrDefault(value, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() >= 2) {
                ans.add(entry.getKey());
            }
        }

        Collections.sort(ans);

        return ans;
    }
}