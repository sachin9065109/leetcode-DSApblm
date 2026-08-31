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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        int groupSize = 1;

        while (curr != null) {
            ListNode groupStart = curr;
            ListNode temp = curr;
            int count = 0;

            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {
                ListNode p = null;
                ListNode c = groupStart;

                for (int i = 0; i < count; i++) {
                    ListNode next = c.next;
                    c.next = p;
                    p = c;
                    c = next;
                }

                if (prev != null) {
                    prev.next = p;
                }

                groupStart.next = c;
                prev = groupStart;
            } else {
                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            curr = temp;
            groupSize++;
        }

        return head;
    }
}