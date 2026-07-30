class Solution {

    public String rankTeams(String[] votes) {

        int n = votes[0].length();

        Map<Character, int[]> map = new HashMap<>();

        for (char c : votes[0].toCharArray()) {
            map.put(c, new int[n]);
        }

        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                char team = vote.charAt(i);
                map.get(team)[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(map.keySet());

        Collections.sort(teams, (a, b) -> {

            int[] cntA = map.get(a);
            int[] cntB = map.get(b);

            for (int i = 0; i < n; i++) {
                if (cntA[i] != cntB[i]) {
                    return cntB[i] - cntA[i];
                }
            }

            return a - b;
        });

        StringBuilder ans = new StringBuilder();

        for (char team : teams)
            ans.append(team);

        return ans.toString();
    }
}