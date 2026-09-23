class Solution {

    public List<String> getNeighbours(String word, HashSet<String> set) {

        List<String> neighbours = new ArrayList<>();

        for (int studentDataIterator = 0;
             studentDataIterator < word.length();
             studentDataIterator++) {

            for (char ch = 'a'; ch <= 'z'; ch++) {

                if (ch == word.charAt(studentDataIterator)) {
                    continue;
                }

                String newWord =
                        word.substring(0, studentDataIterator)
                        + ch
                        + word.substring(studentDataIterator + 1,
                                         word.length());

                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }

        return neighbours;
    }

    public int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 0;

        while (!queue.isEmpty()) {

            int curLevelSize = queue.size();

            for (int studentDataIterator = 0;
                 studentDataIterator < curLevelSize;
                 studentDataIterator++) {

                String node = queue.poll();

                if (node.equals(endWord)) {
                    return level + 1;
                }

                List<String> neighbours =
                        getNeighbours(node, set);

                for (String neighbour : neighbours) {
                    queue.offer(neighbour);
                    set.remove(neighbour);
                }
            }

            level++;
        }

        return 0;
    }
}