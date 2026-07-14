class Solution {
    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> all = new HashSet<>();

        for (int num : nums) {
            all.add(num);
        }

        int totalDistinct = all.size();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> current = new HashSet<>();

            for (int j = i; j < nums.length; j++) {

                current.add(nums[j]);

                if (current.size() == totalDistinct) {
                    count++;
                }
            }
        }

        return count;
    }
}