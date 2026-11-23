class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < list.size(); i++) {
            int prevId = list.get(i - 1)[0];
            int prevHeight = list.get(i - 1)[1];
            int id = list.get(i)[0];

            list.get(i)[1] = Math.min(
                list.get(i)[1],
                prevHeight + id - prevId
            );
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            int nextId = list.get(i + 1)[0];
            int nextHeight = list.get(i + 1)[1];
            int id = list.get(i)[0];

            list.get(i)[1] = Math.min(
                list.get(i)[1],
                nextHeight + nextId - id
            );
        }

        long ans = 0;

        for (int i = 1; i < list.size(); i++) {
            long id1 = list.get(i - 1)[0];
            long h1 = list.get(i - 1)[1];

            long id2 = list.get(i)[0];
            long h2 = list.get(i)[1];

            long distance = id2 - id1;

            long peak = Math.min(
                Math.min(h1 + distance, h2 + distance),
                (h1 + h2 + distance) / 2
            );

            ans = Math.max(ans, peak);
        }

        int lastId = list.get(list.size() - 1)[0];
        int lastHeight = list.get(list.size() - 1)[1];

        ans = Math.max(ans, (long) lastHeight + n - lastId);

        return (int) ans;
    }
}