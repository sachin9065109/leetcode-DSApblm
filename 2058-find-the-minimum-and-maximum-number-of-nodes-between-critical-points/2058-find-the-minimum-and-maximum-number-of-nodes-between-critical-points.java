/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int previous = -1;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            ListNode next = curr.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    first = index;
                } else {
                    minDistance = Math.min(minDistance, index - previous);
                    maxDistance = index - first;
                }

                previous = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        if (first == -1 || previous == first) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}