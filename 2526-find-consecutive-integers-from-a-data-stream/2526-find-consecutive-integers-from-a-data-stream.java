class DataStream {

    private int value;
    private int k;
    private int count;
    private Queue<Integer> queue;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.count = 0;
        this.queue = new LinkedList<>();
    }

    public boolean consec(int num) {
        queue.offer(num);

        if (num == value) {
            count++;
        }

        if (queue.size() > k) {
            int removed = queue.poll();
            if (removed == value) {
                count--;
            }
        }

        return queue.size() == k && count == k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */