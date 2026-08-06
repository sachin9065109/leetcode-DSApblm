class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] freq = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        int pairs = 0;
        for (int x : freq) {
            pairs += x / 2;
        }

        int[] lens = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lens[i] = words[i].length();
        }

        Arrays.sort(lens);

        int ans = 0;
        for (int len : lens) {
            int need = len / 2;
            if (pairs < need) {
                break;
            }
            pairs -= need;
            ans++;
        }

        return ans;
    }
}