class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> set = new HashSet<>();

        for (String word : startWords) {
            int mask = 0;

            for (char ch : word.toCharArray()) {
                mask |= 1 << (ch - 'a');
            }

            set.add(mask);
        }

        int ans = 0;

        for (String word : targetWords) {
            int targetMask = 0;

            for (char ch : word.toCharArray()) {
                targetMask |= 1 << (ch - 'a');
            }

            for (char ch : word.toCharArray()) {
                int startMask = targetMask ^ (1 << (ch - 'a'));

                if (set.contains(startMask)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}