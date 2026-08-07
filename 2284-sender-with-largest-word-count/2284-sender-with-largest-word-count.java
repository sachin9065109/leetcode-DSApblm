class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            int words = 1;
            for (char c : messages[i].toCharArray()) {
                if (c == ' ') {
                    words++;
                }
            }
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words);
        }

        String ans = "";
        int max = 0;

        for (String sender : map.keySet()) {
            int cnt = map.get(sender);

            if (cnt > max || (cnt == max && sender.compareTo(ans) > 0)) {
                max = cnt;
                ans = sender;
            }
        }

        return ans;
    }
}