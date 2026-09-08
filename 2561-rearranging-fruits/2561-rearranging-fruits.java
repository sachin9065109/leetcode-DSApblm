

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;

        for (int x : basket1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            minValue = Math.min(minValue, x);
        }

        for (int x : basket2) {
            map.put(x, map.getOrDefault(x, 0) - 1);
            minValue = Math.min(minValue, x);
        }

        List<Integer> extra = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int diff = entry.getValue();

            if (Math.abs(diff) % 2 != 0) {
                return -1;
            }

            int count = Math.abs(diff) / 2;

            for (int i = 0; i < count; i++) {
                extra.add(value);
            }
        }

        Collections.sort(extra);

        long ans = 0;
        int swaps = extra.size() / 2;

        for (int i = 0; i < swaps; i++) {
            ans += Math.min((long) extra.get(i), 2L * minValue);
        }

        return ans;
    }
}