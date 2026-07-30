class Solution {
    public int minSetSize(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(freq.values());

        Collections.sort(list, Collections.reverseOrder());

        int removed = 0;
        int count = 0;
        int target = arr.length / 2;

        for (int f : list) {
            removed += f;
            count++;

            if (removed >= target)
                return count;
        }

        return count;
    }
}