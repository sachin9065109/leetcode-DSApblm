class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }

        int[] evenTop1 = getTop(even);
        int[] evenTop2 = getSecond(even, evenTop1[0]);

        int[] oddTop1 = getTop(odd);
        int[] oddTop2 = getSecond(odd, oddTop1[0]);

        int evenCount = even.size() > 0 ? evenTop1[1] : 0;
        int oddCount = odd.size() > 0 ? oddTop1[1] : 0;

        int ans;

        if (evenTop1[0] != oddTop1[0]) {
            ans = nums.length - evenCount - oddCount;
        } else {
            int option1 = nums.length - evenCount - oddTop2[1];
            int option2 = nums.length - evenTop2[1] - oddCount;

            ans = Math.min(option1, option2);
        }

        return ans;
    }

    private int[] getTop(HashMap<Integer, Integer> map) {
        int value = -1;
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                value = entry.getKey();
            }
        }

        return new int[]{value, count};
    }

    private int[] getSecond(HashMap<Integer, Integer> map, int firstValue) {
        int value = -1;
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() != firstValue && entry.getValue() > count) {
                count = entry.getValue();
                value = entry.getKey();
            }
        }

        return new int[]{value, count};
    }
}