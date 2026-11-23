class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int start = Integer.parseInt(loginTime.substring(0, 2)) * 60
                  + Integer.parseInt(loginTime.substring(3, 5));

        int end = Integer.parseInt(logoutTime.substring(0, 2)) * 60
                + Integer.parseInt(logoutTime.substring(3, 5));

        if (end < start) {
            end += 1440;
        }

        int firstRound = (start + 14) / 15;
        int lastRound = end / 15;

        return Math.max(0, lastRound - firstRound);
    }
}