class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {

            int len = r[i] - l[i] + 1;
            int[] arr = new int[len];

            for (int j = 0; j < len; j++) {
                arr[j] = nums[l[i] + j];
            }

            Arrays.sort(arr);

            boolean ok = true;
            int diff = arr[1] - arr[0];

            for (int j = 2; j < len; j++) {
                if (arr[j] - arr[j - 1] != diff) {
                    ok = false;
                    break;
                }
            }

            ans.add(ok);
        }

        return ans;
    }
}