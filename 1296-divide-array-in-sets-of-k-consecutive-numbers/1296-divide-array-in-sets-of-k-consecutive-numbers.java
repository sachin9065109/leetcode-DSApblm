class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        if (nums.length % k != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {

            int start = map.firstKey();

            for (int i = 0; i < k; i++) {

                int curr = start + i;

                if (!map.containsKey(curr))
                    return false;

                int freq = map.get(curr);

                if (freq == 1)
                    map.remove(curr);
                else
                    map.put(curr, freq - 1);
            }
        }

        return true;
    }
}