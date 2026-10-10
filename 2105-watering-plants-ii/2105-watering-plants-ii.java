class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;

        int alice = capacityA;
        int bob = capacityB;
        int refills = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (alice < plants[left]) {
                refills++;
                alice = capacityA;
            }
            alice -= plants[left];
            left++;

            if (bob < plants[right]) {
                refills++;
                bob = capacityB;
            }
            bob -= plants[right];
            right--;
        }

        if (left == right) {
            if (Math.max(alice, bob) < plants[left]) {
                refills++;
            }
        }

        return refills;
    }
}