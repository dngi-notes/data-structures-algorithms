package blind75.trees.lc_297_serialize_deserialize_tree;

import data_structures.TreeNode;

public class Solution {
    /**
     * Serialization is the process of converting a data structure or object into a
     * sequence of bits so that it can be stored in a file or memory buffer, or
     * transmitted across a network connection link to be reconstructed later in the
     * same or another computer environment.
     * 
     * Design an algorithm to serialize and deserialize a binary tree. There is no
     * restriction on how your serialization/deserialization algorithm should work.
     * You just need to ensure that a binary tree can be serialized to a string and
     * this string can be deserialized to the original tree structure.
     * 
     * Clarification: The input/output format is the same as how LeetCode serializes
     * a binary tree. You do not necessarily need to follow this format, so please
     * be creative and come up with different approaches yourself.
     */
    private static final String NULL = "null";
    private static final String DELIM = ",";

    private int idx;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        if (data.endsWith(DELIM)) {
            data = data.substring(0, data.length() - 1);
        }

        String[] tokens = data.split(DELIM);
        idx = 0;
        return buildTree(tokens);
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(DELIM);
            return;
        }
        
        sb.append(node.val).append(DELIM);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    private TreeNode buildTree(String[] tokens) {
        if (idx >= tokens.length) return null;
        
        String token = tokens[idx++];
        if (token.equals(NULL)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = buildTree(tokens);
        node.right = buildTree(tokens);
        return node;
    }

    public static void main(String[] args) {
        Solution ser = new Solution();
        Solution deser = new Solution();
        TreeNode ans = deser.deserialize(ser.serialize(TreeNode.createSampleTreeNode()));
        System.out.println(ans);
    }
}
