class Solution {

    public int incremovableSubarrayCount(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int l = 0; l < n; l++) {

            for (int r = l; r < n; r++) {

                int prev = -1;
                boolean ok = true;

                for (int i = 0; i < n; i++) {

                    if (i >= l && i <= r)
                        continue;

                    if (prev != -1 && nums[i] <= prev) {
                        ok = false;
                        break;
                    }

                    prev = nums[i];
                }

                if (ok)
                    ans++;
            }
        }

        return ans;
    }
}