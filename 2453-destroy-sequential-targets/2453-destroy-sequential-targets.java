class Solution {
    public int destroyTargets(int[] nums, int space) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> minVal = new HashMap<>();

        for (int num : nums) {
            int rem = num % space;

            freq.put(rem, freq.getOrDefault(rem, 0) + 1);

            minVal.put(rem, Math.min(
                minVal.getOrDefault(rem, Integer.MAX_VALUE),
                num
            ));
        }

        int maxFreq = 0;
        int ans = Integer.MAX_VALUE;

        for (int rem : freq.keySet()) {

            int count = freq.get(rem);
            int min = minVal.get(rem);

            if (count > maxFreq) {
                maxFreq = count;
                ans = min;
            } 
            else if (count == maxFreq) {
                ans = Math.min(ans, min);
            }
        }

        return ans;
    }
}
