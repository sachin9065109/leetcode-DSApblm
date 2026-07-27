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

    Map<Integer, TreeNode> map = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        Map<Integer, Integer> cnt = new HashMap<>();

        for (TreeNode root : trees) {
            map.put(root.val, root);
            cnt.put(root.val, cnt.getOrDefault(root.val, 0) + 1);

            if (root.left != null)
                cnt.put(root.left.val, cnt.getOrDefault(root.left.val, 0) + 1);

            if (root.right != null)
                cnt.put(root.right.val, cnt.getOrDefault(root.right.val, 0) + 1);
        }

        TreeNode root = null;

        for (TreeNode t : trees) {
            if (cnt.get(t.val) == 1) {
                root = t;
                break;
            }
        }

        if (root == null) return null;

        map.remove(root.val);

        if (!check(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        return map.isEmpty() ? root : null;
    }

    private boolean check(TreeNode node, long low, long high) {

        if (node == null) return true;

        if (node.val <= low || node.val >= high)
            return false;

        if (node.left == null && node.right == null && map.containsKey(node.val)) {

            TreeNode merge = map.remove(node.val);

            node.left = merge.left;
            node.right = merge.right;
        }

        return check(node.left, low, node.val) &&
               check(node.right, node.val, high);
    }
}