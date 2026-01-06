package blind75.trees.lc98_validate_bst;

import data_structures.TreeNode;

public class Solution {
    /**
     * Given the root of a binary tree, determine if it is a valid binary search
     * tree (BST).
     * 
     * A valid BST is defined as follows:
     * 
     * The left
     * 
     * of a node contains only nodes with keys strictly less than the node's key.
     * The right subtree of a node contains only nodes with keys strictly greater
     * than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * 
     * e.g.
     * in: root = [2, 1, 3]
     * out: true
     * 
     * in: [2, 3, 1]
     * out: false
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);        
    }

    private boolean isValid(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;

        if (!(node.val > minValue && node.val < maxValue)) {
            return false;
        }

        boolean isValidLeft = isValid(node.left, minValue, node.val);
        boolean isValidRight = isValid(node.right, node.val, maxValue);

        return isValidLeft && isValidRight;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3)); // expected: true
        TreeNode root2 = new TreeNode(2, new TreeNode(3), new TreeNode(1)); // expected: false

        System.out.println(ss.isValidBST(root));
        System.out.println(ss.isValidBST(root2));
    }
}
