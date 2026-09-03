

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int len = nums[0].length();

        int[] answer = new int[q];

        for (int qi = 0; qi < q; qi++) {
            int k = queries[qi][0];
            int trim = queries[qi][1];

            Integer[] indices = new Integer[n];

            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            Arrays.sort(indices, (a, b) -> {
                String sa = nums[a].substring(len - trim);
                String sb = nums[b].substring(len - trim);

                int cmp = sa.compareTo(sb);

                if (cmp != 0) {
                    return cmp;
                }

                return Integer.compare(a, b);
            });

            answer[qi] = indices[k - 1];
        }

        return answer;
    }
}
