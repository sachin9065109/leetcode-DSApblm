class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b);
            int high = Math.max(a, b);

            int sum = a + b;

           
            diff[low + 1] -= 1;
            diff[high + limit + 1] += 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = n;
        int moves = n; 

        for (int target = 2; target <= 2 * limit; target++) {
            moves += diff[target];
            ans = Math.min(ans, moves);
        }

        return ans;
    }
}