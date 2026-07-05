class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;

        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + travel[i - 1];
        }

        int totalGarbage = 0;
        int lastM = -1, lastP = -1, lastG = -1;

        for (int i = 0; i < n; i++) {
            totalGarbage += garbage[i].length();

            for (char ch : garbage[i].toCharArray()) {
                if (ch == 'M') {
                    lastM = i;
                } else if (ch == 'P') {
                    lastP = i;
                } else { 
                    lastG = i;
                }
            }
        }

        int ans = totalGarbage;

        if (lastM != -1) ans += prefix[lastM];
        if (lastP != -1) ans += prefix[lastP];
        if (lastG != -1) ans += prefix[lastG];

        return ans;
    }
}