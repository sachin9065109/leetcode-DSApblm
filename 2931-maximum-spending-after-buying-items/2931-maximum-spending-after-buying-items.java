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

    public long maxSpending(int[][] values) {

        int m = values.length;
        int n = values[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < m; i++) {
            pq.offer(new Node(values[i][n - 1], i, n - 1));
        }

        long day = 1;
        long ans = 0;

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            ans += day * cur.value;
            day++;

            if (cur.col > 0) {
                pq.offer(new Node(values[cur.row][cur.col - 1], cur.row, cur.col - 1));
            }
        }

        return ans;
    }
}