class Solution {
    public int maxIceCream(int[] costs, int coins) {

        // Find maximum cost
        int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int price = 1; price <= maxCost; price++) {

            if (freq[price] == 0) {
                continue;
            }

            int canBuy = coins / price;

            int buy = Math.min(freq[price], canBuy);

            count += buy;
            coins -= buy * price;

            if (coins < price) {
                break;
            }
        }

        return count;
    }
}