import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) ->
            Long.compare(
                (long) wage[a] * quality[b],
                (long) wage[b] * quality[a]
            )
        );

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        long qualitySum = 0;
        double ans = Double.MAX_VALUE;

        for (int i : idx) {
            qualitySum += quality[i];
            maxHeap.offer(quality[i]);

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                double ratio = (double) wage[i] / quality[i];
                ans = Math.min(ans, qualitySum * ratio);
            }
        }

        return ans;
    }
}