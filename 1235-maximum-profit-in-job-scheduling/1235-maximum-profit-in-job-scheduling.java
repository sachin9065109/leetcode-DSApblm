class Solution {

    class Job {
        int start, end, profit;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }

    Job[] jobs;
    int[] dp;
    int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        n = startTime.length;
        jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0);
    }

    private int solve(int idx) {

        if (idx == n)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int skip = solve(idx + 1);

        int next = binarySearch(jobs[idx].end);
        int take = jobs[idx].profit + solve(next);

        return dp[idx] = Math.max(skip, take);
    }

    private int binarySearch(int target) {

        int left = 0;
        int right = n - 1;
        int ans = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (jobs[mid].start >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}