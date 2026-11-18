class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);

        char maxDigit = 0;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxDigit = c;
                break;
            }
        }

        String maxStr = s;
        if (maxDigit != 0) {
            maxStr = s.replace(maxDigit, '9');
        }

        char minDigit = 0;
        char minReplace = 0;

        if (s.charAt(0) != '1') {
            minDigit = s.charAt(0);
            minReplace = '1';
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    minDigit = s.charAt(i);
                    minReplace = '0';
                    break;
                }
            }
        }

        String minStr = s;
        if (minDigit != 0) {
            minStr = s.replace(minDigit, minReplace);
        }

        int max = Integer.parseInt(maxStr);
        int min = Integer.parseInt(minStr);

        return max - min;
    }
}