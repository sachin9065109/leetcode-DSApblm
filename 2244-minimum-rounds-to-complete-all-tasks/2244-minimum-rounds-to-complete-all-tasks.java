class Solution {
    public int minimumRounds(int[] tasks) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int ans = 0;

        for (int freq : map.values()) {

            if (freq == 1) {
                return -1;
            }

            ans += (freq + 2) / 3;
        }

        return ans;
    }
}