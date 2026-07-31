/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = 0;

    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Info dfs(TreeNode node) {

        if (node == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        if (left.isBST && right.isBST &&
            node.val > left.max &&
            node.val < right.min) {

            int sum = left.sum + right.sum + node.val;
            ans = Math.max(ans, sum);

            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return new Info(true, min, max, sum);
        }

        return new Info(false, 0, 0, 0);
    }
}