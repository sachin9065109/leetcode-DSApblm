class Solution {
    public int[] minOperations(int[] nums) {

        List<Integer> pal = new ArrayList<>();

        for (int i = 1; i <= 16383; i++) {
            if (isPalindrome(i))
                pal.add(i);
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int idx = Collections.binarySearch(pal, nums[i]);

            if (idx >= 0) {
                ans[i] = 0;
                continue;
            }

            idx = -idx - 1;

            int best = Integer.MAX_VALUE;

            if (idx < pal.size())
                best = Math.min(best, Math.abs(pal.get(idx) - nums[i]));

            if (idx > 0)
                best = Math.min(best, Math.abs(nums[i] - pal.get(idx - 1)));

            ans[i] = best;
        }

        return ans;
    }

    private boolean isPalindrome(int x) {
        String s = Integer.toBinaryString(x);

        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}