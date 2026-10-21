import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int i = 25;

        while (i >= 0) {
            if (freq[i] == 0) {
                i--;
                continue;
            }

            int count = Math.min(freq[i], repeatLimit);

            for (int j = 0; j < count; j++) {
                result.append((char) ('a' + i));
            }

            freq[i] -= count;

            if (freq[i] == 0) {
                continue;
            }

            int j = i - 1;

            while (j >= 0 && freq[j] == 0) {
                j--;
            }

            if (j < 0) {
                break;
            }

            result.append((char) ('a' + j));
            freq[j]--;
        }

        return result.toString();
    }
}