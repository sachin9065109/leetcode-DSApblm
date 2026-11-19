class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int ans = Integer.MAX_VALUE;

        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;

        if (minutes <= 99) {
            ans = Math.min(ans, cost(startAt, moveCost, pushCost, minutes, seconds));
        }

        if (minutes > 0 && seconds + 60 <= 99) {
            ans = Math.min(ans, cost(startAt, moveCost, pushCost, minutes - 1, seconds + 60));
        }

        return ans;
    }

    private int cost(int startAt, int moveCost, int pushCost, int minutes, int seconds) {
        String s = String.format("%02d%02d", minutes, seconds);

        int i = 0;

        while (i < 3 && s.charAt(i) == '0') {
            i++;
        }

        int current = startAt;
        int cost = 0;

        while (i < 4) {
            int digit = s.charAt(i) - '0';

            if (digit != current) {
                cost += moveCost;
                current = digit;
            }

            cost += pushCost;
            i++;
        }

        return cost;
    }
}