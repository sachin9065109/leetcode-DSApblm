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

    public ListNode doubleIt(ListNode head) {
        int carry = doubleNode(head);

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    private int doubleNode(ListNode node) {

        if (node == null) {
            return 0;
        }

        int carry = doubleNode(node.next);

        int value = node.val * 2 + carry;

        node.val = value % 10;

        return value / 10;
    }
}