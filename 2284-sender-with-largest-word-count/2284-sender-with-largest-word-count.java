class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            int count = messages[i].split(" ").length;
            wordCount.put(senders[i], wordCount.getOrDefault(senders[i], 0) + count);
        }

        String result = "";
        int maxCount = 0;

        for (String sender : wordCount.keySet()) {
            int count = wordCount.get(sender);

            if (count > maxCount || (count == maxCount && sender.compareTo(result) > 0)) {
                maxCount = count;
                result = sender;
            }
        }

        return result;
    }
}