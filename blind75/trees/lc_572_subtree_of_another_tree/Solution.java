package blind75.trees.lc_572_subtree_of_another_tree;

import data_structures.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return checkSubTree(root, subRoot);
    }

    private boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        return (checkSubTree(left, subRoot) || checkSubTree(right, subRoot));
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        boolean isSameLeft = isSameTree(node1.left, node2.left);
        boolean isSameRight = isSameTree(node1.right, node2.right);

        return (isSameLeft && isSameRight);
    }
}
