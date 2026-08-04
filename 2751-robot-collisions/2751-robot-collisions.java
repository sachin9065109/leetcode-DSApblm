class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        int[][] robots = new int[n][2];
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = i;
        }

        Arrays.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<Integer> stack = new Stack<>();

        for (int[] robot : robots) {
            int idx = robot[1];

            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty() && healths[idx] > 0) {
                    int j = stack.peek();

                    if (healths[j] < healths[idx]) {
                        stack.pop();
                        healths[idx]--;
                        healths[j] = 0;
                    } else if (healths[j] > healths[idx]) {
                        healths[j]--;
                        healths[idx] = 0;
                    } else {
                        stack.pop();
                        healths[j] = 0;
                        healths[idx] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                ans.add(healths[i]);
            }
        }

        return ans;
    }
}