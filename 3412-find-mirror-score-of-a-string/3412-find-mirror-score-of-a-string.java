class Solution {
    public long calculateScore(String s) {
        Stack<Integer>[] stacks = new Stack[26];

        for (int i = 0; i < 26; i++) {
            stacks[i] = new Stack<>();
        }

        long score = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            int mirror = 25 - current;

            if (!stacks[mirror].isEmpty()) {
                int j = stacks[mirror].pop();
                score += i - j;
            } else {
                stacks[current].push(i);
            }
        }

        return score;
    }
}