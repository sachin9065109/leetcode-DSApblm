class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballColor = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();

        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);

                colorCount.put(oldColor, colorCount.get(oldColor) - 1);

                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            ballColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            result[i] = colorCount.size();
        }

        return result;
    }
}