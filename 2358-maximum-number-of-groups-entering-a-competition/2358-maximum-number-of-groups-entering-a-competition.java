class Solution {
    public int maximumGroups(int[] grades) {

        int n = grades.length;
        int groups = 0;
        int need = 1;

        while (n >= need) {
            n -= need;
            groups++;
            need++;
        }

        return groups;
    }
}