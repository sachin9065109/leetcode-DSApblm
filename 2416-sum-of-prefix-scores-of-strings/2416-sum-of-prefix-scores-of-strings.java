class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count = 0;
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new TrieNode();
                }
                curr = curr.child[idx];
                curr.count++;
            }
        }

        int[] ans = new int[words.length];

        // Calculate prefix scores
        for (int i = 0; i < words.length; i++) {
            TrieNode curr = root;
            int score = 0;

            for (char ch : words[i].toCharArray()) {
                curr = curr.child[ch - 'a'];
                score += curr.count;
            }

            ans[i] = score;
        }

        return ans;
    }
}