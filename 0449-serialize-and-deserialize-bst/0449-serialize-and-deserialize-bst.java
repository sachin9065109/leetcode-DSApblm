/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }


    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] arr = data.split(",");

        int[] index = {0};

        return build(arr, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private TreeNode build(String[] arr, int[] index, int min, int max) {

        if (index[0] == arr.length) {
            return null;
        }

        int value = Integer.parseInt(arr[index[0]]);

        if (value < min || value > max) {
            return null;
        }

        TreeNode root = new TreeNode(value);

        index[0]++;

        root.left = build(arr, index, min, value);

        root.right = build(arr, index, value, max);

        return root;
    }
}



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;