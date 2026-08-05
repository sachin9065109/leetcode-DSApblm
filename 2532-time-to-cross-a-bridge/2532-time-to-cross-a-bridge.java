class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {

        PriorityQueue<Integer> waitLeft = new PriorityQueue<>((a, b) -> {
            int ea = time[a][0] + time[a][2];
            int eb = time[b][0] + time[b][2];
            if (ea != eb) return eb - ea;
            return b - a;
        });

        PriorityQueue<Integer> waitRight = new PriorityQueue<>((a, b) -> {
            int ea = time[a][0] + time[a][2];
            int eb = time[b][0] + time[b][2];
            if (ea != eb) return eb - ea;
            return b - a;
        });

        PriorityQueue<int[]> workLeft =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> workRight =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < k; i++) {
            waitLeft.offer(i);
        }

        int cur = 0;
        int ans = 0;
        int remain = n;

        while (remain > 0 || !waitRight.isEmpty() || !workRight.isEmpty()) {

            while (!workLeft.isEmpty() && workLeft.peek()[0] <= cur) {
                waitLeft.offer(workLeft.poll()[1]);
            }

            while (!workRight.isEmpty() && workRight.peek()[0] <= cur) {
                waitRight.offer(workRight.poll()[1]);
            }

            if (!waitRight.isEmpty()) {
                int id = waitRight.poll();
                cur += time[id][2];
                ans = cur;
                workLeft.offer(new int[]{cur + time[id][3], id});
            } else if (remain > 0 && !waitLeft.isEmpty()) {
                int id = waitLeft.poll();
                cur += time[id][0];
                remain--;
                workRight.offer(new int[]{cur + time[id][1], id});
            } else {
                int next = Integer.MAX_VALUE;
                if (!workLeft.isEmpty()) next = Math.min(next, workLeft.peek()[0]);
                if (!workRight.isEmpty()) next = Math.min(next, workRight.peek()[0]);
                cur = next;
            }
        }

        return ans;
    }
}