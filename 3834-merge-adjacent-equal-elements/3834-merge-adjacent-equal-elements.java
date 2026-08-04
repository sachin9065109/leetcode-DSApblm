import java.util.*;

class Solution {

    public List<Long> mergeAdjacent(int[] nums) {

        LinkedList<Long> list = new LinkedList<>();

        for (int x : nums) {

            list.add((long) x);

            while (list.size() >= 2) {

                long last = list.removeLast();
                long secondLast = list.removeLast();

                if (last == secondLast) {
                    list.add(last + secondLast);
                } else {
                    list.add(secondLast);
                    list.add(last);
                    break;
                }
            }
        }

        return list;
    }
}