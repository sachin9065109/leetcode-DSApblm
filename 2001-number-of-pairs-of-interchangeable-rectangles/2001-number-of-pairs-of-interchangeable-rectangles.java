class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<String, Long> map = new HashMap<>();
        long ans = 0;

        for (int[] r : rectangles) {
            int w = r[0];
            int h = r[1];

            int g = gcd(w, h);
            w /= g;
            h /= g;

            String ratio = w + "/" + h;

            long count = map.getOrDefault(ratio, 0L);
            ans += count;

            map.put(ratio, count + 1);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}