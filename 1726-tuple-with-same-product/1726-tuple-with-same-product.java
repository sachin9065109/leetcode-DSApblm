class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];

                int count = productCount.getOrDefault(product, 0);

                answer += count * 8;

                productCount.put(product, count + 1);
            }
        }

        return answer;
    }
}