class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        // Remove duplicates
        ArrayList<Integer> unique = new ArrayList<>();
        for (int x : nums) {
            if (unique.isEmpty() || unique.get(unique.size() - 1) != x) {
                unique.add(x);
            }
        }

        int m = unique.size();
        int ans = n;

        for (int i = 0; i < m; i++) {

            int target = unique.get(i) + n - 1;

            int j = upperBound(unique, target);

            int keep = j - i;

            ans = Math.min(ans, n - keep);
        }

        return ans;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {

        int left = 0;
        int right = arr.size();

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}