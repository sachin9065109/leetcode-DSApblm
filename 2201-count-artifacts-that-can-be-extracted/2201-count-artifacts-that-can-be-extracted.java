class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<String> dug = new HashSet<>();

        for (int[] cell : dig) {
            dug.add(cell[0] + "#" + cell[1]);
        }

        int count = 0;

        for (int[] art : artifacts) {
            boolean extracted = true;

            for (int r = art[0]; r <= art[2] && extracted; r++) {
                for (int c = art[1]; c <= art[3]; c++) {
                    if (!dug.contains(r + "#" + c)) {
                        extracted = false;
                        break;
                    }
                }
            }

            if (extracted) count++;
        }

        return count;
    }
}