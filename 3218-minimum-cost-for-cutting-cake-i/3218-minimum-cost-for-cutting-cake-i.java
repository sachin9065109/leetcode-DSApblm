class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int i = horizontalCut.length - 1;
        int j = verticalCut.length - 1;

        long ans = 0;
        int hPieces = 1;
        int vPieces = 1;

        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] >= verticalCut[j]) {
                ans += 1L * horizontalCut[i] * vPieces;
                hPieces++;
                i--;
            } else {
                ans += 1L * verticalCut[j] * hPieces;
                vPieces++;
                j--;
            }
        }

        while (i >= 0) {
            ans += 1L * horizontalCut[i] * vPieces;
            hPieces++;
            i--;
        }

        while (j >= 0) {
            ans += 1L * verticalCut[j] * hPieces;
            vPieces++;
            j--;
        }

        return (int) ans;
    }
}