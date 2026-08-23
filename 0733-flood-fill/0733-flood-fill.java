class Solution {

    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        m = image.length;
        n = image[0].length;

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    void dfs(int[][] image, int i, int j,
             int originalColor, int newColor) {

        if (i < 0 || j < 0 ||
            i >= m || j >= n ||
            image[i][j] != originalColor) {
            return;
        }

        image[i][j] = newColor;

        dfs(image, i - 1, j, originalColor, newColor);
        dfs(image, i, j + 1, originalColor, newColor);
        dfs(image, i + 1, j, originalColor, newColor);
        dfs(image, i, j - 1, originalColor, newColor);
    }
}