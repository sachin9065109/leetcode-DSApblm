class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int idx : queries) {
            List<Integer> list = map.get(nums[idx]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int res = Integer.MAX_VALUE;

            if (pos > 0) {
                int prev = list.get(pos - 1);
                int d = Math.abs(idx - prev);
                res = Math.min(res, Math.min(d, n - d));
            } else {
                int prev = list.get(list.size() - 1);
                int d = Math.abs(idx - prev);
                res = Math.min(res, Math.min(d, n - d));
            }

            if (pos < list.size() - 1) {
                int next = list.get(pos + 1);
                int d = Math.abs(idx - next);
                res = Math.min(res, Math.min(d, n - d));
            } else {
                int next = list.get(0);
                int d = Math.abs(idx - next);
                res = Math.min(res, Math.min(d, n - d));
            }

            ans.add(res);
        }

        return ans;
    }
}