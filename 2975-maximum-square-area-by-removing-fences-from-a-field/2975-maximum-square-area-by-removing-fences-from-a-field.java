class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1000000007;

        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        for (int i = 0; i < hFences.length; i++) {
            h[i] = hFences[i];
        }

        for (int i = 0; i < vFences.length; i++) {
            v[i] = vFences[i];
        }

        h[hFences.length] = 1;
        h[hFences.length + 1] = m;

        v[vFences.length] = 1;
        v[vFences.length + 1] = n;

        Arrays.sort(h);
        Arrays.sort(v);

        HashSet<Integer> horizontal = new HashSet<>();

        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                horizontal.add(h[j] - h[i]);
            }
        }

        long maxSide = -1;

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int side = v[j] - v[i];

                if (horizontal.contains(side)) {
                    maxSide = Math.max(maxSide, side);
                }
            }
        }

        if (maxSide == -1) {
            return -1;
        }

        return (int) ((maxSide * maxSide) % MOD);
    }
}