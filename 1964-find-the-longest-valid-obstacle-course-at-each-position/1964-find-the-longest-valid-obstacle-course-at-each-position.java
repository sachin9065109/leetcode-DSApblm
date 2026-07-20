class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int n = obstacles.length;
        int[] ans = new int[n];

        ArrayList<Integer> tails = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int pos = upperBound(tails, obstacles[i]);

            if (pos == tails.size()) {
                tails.add(obstacles[i]);
            } else {
                tails.set(pos, obstacles[i]);
            }

            ans[i] = pos + 1;
        }

        return ans;
    }

    private int upperBound(ArrayList<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}