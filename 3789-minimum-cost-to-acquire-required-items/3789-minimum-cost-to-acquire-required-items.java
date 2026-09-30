class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long both = Math.min(need1, need2);

        long ans = both * Math.min(costBoth, cost1 + cost2);

        if (need1 > both) {
            ans += (need1 - both) * Math.min(cost1, costBoth);
        }

        if (need2 > both) {
            ans += (need2 - both) * Math.min(cost2, costBoth);
        }

        return ans;
    }
}