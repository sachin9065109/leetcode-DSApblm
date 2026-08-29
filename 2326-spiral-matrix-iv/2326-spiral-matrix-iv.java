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
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        ListNode curr = head;

        while (curr != null && top <= bottom && left <= right) {

            for (int j = left; j <= right && curr != null; j++) {
                matrix[top][j] = curr.val;
                curr = curr.next;
            }
            top++;

            for (int i = top; i <= bottom && curr != null; i++) {
                matrix[i][right] = curr.val;
                curr = curr.next;
            }
            right--;

            for (int j = right; j >= left && curr != null; j--) {
                matrix[bottom][j] = curr.val;
                curr = curr.next;
            }
            bottom--;

            for (int i = bottom; i >= top && curr != null; i--) {
                matrix[i][left] = curr.val;
                curr = curr.next;
            }
            left++;
        }

        return matrix;
    }
}