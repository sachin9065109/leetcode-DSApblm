class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int maxFreq = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            int count = freq.getOrDefault(x, 0) + 1;
            freq.put(x, count);
            maxFreq = Math.max(maxFreq, count);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < maxFreq; i++) {
            ans.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                ans.get(i).add(value);
            }
        }

        return ans;
    }
}