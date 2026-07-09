class Solution {

    class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new Node(val, i, 0));
            max = Math.max(max, val);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (true) {

            Node curr = pq.poll();
            int min = curr.value;

            if (max - min < end - start ||
                (max - min == end - start && min < start)) {
                start = min;
                end = max;
            }

            if (curr.col + 1 == nums.get(curr.row).size()) {
                break;
            }

            int nextVal = nums.get(curr.row).get(curr.col + 1);

            pq.offer(new Node(nextVal, curr.row, curr.col + 1));

            max = Math.max(max, nextVal);
        }

        return new int[]{start, end};
    }
}