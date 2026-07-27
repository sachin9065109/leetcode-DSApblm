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

    List<Integer> inorder = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);

        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            int floor = getFloor(q);
            int ceil = getCeil(q);

            ans.add(Arrays.asList(floor, ceil));
        }

        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);
        inorder.add(node.val);
        dfs(node.right);
    }

    private int getFloor(int target) {
        int l = 0, r = inorder.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (inorder.get(mid) <= target) {
                ans = inorder.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private int getCeil(int target) {
        int l = 0, r = inorder.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (inorder.get(mid) >= target) {
                ans = inorder.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}