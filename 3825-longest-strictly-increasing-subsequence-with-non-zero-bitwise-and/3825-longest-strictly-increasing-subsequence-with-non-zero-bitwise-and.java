class Solution {
    public int longestSubsequence(int[] nums) {
        int answer = 0;

        for (int bit = 0; bit <= 30; bit++) {
            ArrayList<Integer> lis = new ArrayList<>();

            for (int num : nums) {
                if ((num & (1 << bit)) == 0) {
                    continue;
                }

                int left = 0;
                int right = lis.size();

                while (left < right) {
                    int mid = left + (right - left) / 2;

                    if (lis.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (left == lis.size()) {
                    lis.add(num);
                } else {
                    lis.set(left, num);
                }
            }

            answer = Math.max(answer, lis.size());
        }

        return answer;
    }
}