class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int n = skill.length;
        int target = skill[0] + skill[n - 1];

        long ans = 0;

        int i = 0, j = n - 1;

        while (i < j) {
            if (skill[i] + skill[j] != target)
                return -1;

            ans += 1L * skill[i] * skill[j];
            i++;
            j--;
        }

        return ans;
    }
}