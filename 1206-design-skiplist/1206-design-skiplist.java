class Skiplist {

    static final int MAX_LEVEL = 16;

    static class Node {
        int val;
        Node[] next;

        Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }

    Node head;
    Random random;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        random = new Random();
    }

    private int randomLevel() {
        int level = 1;

        while (level < MAX_LEVEL && random.nextBoolean()) {
            level++;
        }

        return level;
    }

    public boolean search(int target) {
        Node curr = head;

        for (int level = MAX_LEVEL - 1; level >= 0; level--) {
            while (curr.next[level] != null &&
                   curr.next[level].val < target) {
                curr = curr.next[level];
            }
        }

        curr = curr.next[0];

        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];

        Node curr = head;

        for (int level = MAX_LEVEL - 1; level >= 0; level--) {
            while (curr.next[level] != null &&
                   curr.next[level].val < num) {
                curr = curr.next[level];
            }

            update[level] = curr;
        }

        int levelCount = randomLevel();

        Node newNode = new Node(num, levelCount);

        for (int level = 0; level < levelCount; level++) {
            newNode.next[level] = update[level].next[level];
            update[level].next[level] = newNode;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];

        Node curr = head;

        for (int level = MAX_LEVEL - 1; level >= 0; level--) {
            while (curr.next[level] != null &&
                   curr.next[level].val < num) {
                curr = curr.next[level];
            }

            update[level] = curr;
        }

        curr = curr.next[0];

        if (curr == null || curr.val != num) {
            return false;
        }

        for (int level = 0; level < MAX_LEVEL; level++) {
            if (update[level].next[level] != curr) {
                break;
            }

            update[level].next[level] = curr.next[level];
        }

        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */