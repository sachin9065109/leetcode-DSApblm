class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        
        int i = 0;
        for (int[] q : sortedQueries) {
            int qVal = q[0];
            int qIdx = q[1];
            
            while (i < n && intervals[i][0] <= qVal) {
                int size = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{size, intervals[i][1]});
                i++;
            }
            
            while (!pq.isEmpty() && pq.peek()[1] < qVal) {
                pq.poll();
            }
            
            if (!pq.isEmpty()) {
                ans[qIdx] = pq.peek()[0];
            }
        }
        
        return ans;
    }
}