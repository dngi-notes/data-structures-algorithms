package blind75.trees.lc_226_invert_binary_tree;

import data_structures.TreeNode;

public class Solution {
    /**
     * Given the root of a binary tree,
     * invert the tree and return its root
     */
    public TreeNode invertTree(TreeNode root) {
        return invert(root);        
    }

    private TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode n = new TreeNode(node.val);
        n.left = invert(node.right);
        n.right = invert(node.left);
        
        return n;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode sample = TreeNode.createSampleTreeNode();

        System.out.println(ss.invertTree(sample));
    }
}
