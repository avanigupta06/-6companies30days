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

    public void serializeHelper(TreeNode root, StringBuilder output) {
        if (root == null) {
            output.append("* ");
            return;
        }
        output.append(root.val).append(" ");
        serializeHelper(root.left, output);
        serializeHelper(root.right, output);
    }

    public String serialize(TreeNode root) {
        StringBuilder output = new StringBuilder();
        serializeHelper(root, output);
        return output.toString();
    }

    public TreeNode deserializeHelper(String[] data, int[] index) {
        if (index[0] >= data.length) return null;
        String currVal = data[index[0]];
        index[0]++;
        if (currVal.equals("*")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(currVal));
        root.left = deserializeHelper(data, index);
        root.right = deserializeHelper(data, index);
        return root;
    }

    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(" ");
        int[] index = new int[1];
        return deserializeHelper(nodeValues, index);
    }
}
//Time Complexity: O(n) 
//Space Complexity: O(n)