class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int freq : map.values()) {
            pq.offer(freq);
        }

        int unique = map.size();

        while (!pq.isEmpty() && k >= pq.peek()) {
            k -= pq.poll();
            unique--;
        }

        return unique;
    }
}