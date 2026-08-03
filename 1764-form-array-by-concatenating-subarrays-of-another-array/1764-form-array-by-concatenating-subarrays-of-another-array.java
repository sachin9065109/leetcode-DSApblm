class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int idx = 0;

        for (int[] group : groups) {

            boolean found = false;

            while (idx + group.length <= nums.length) {

                int j = 0;
                while (j < group.length && nums[idx + j] == group[j]) {
                    j++;
                }

                if (j == group.length) {
                    found = true;
                    idx += group.length;
                    break;
                }

                idx++;
            }

            if (!found) return false;
        }

        return true;
    }
}