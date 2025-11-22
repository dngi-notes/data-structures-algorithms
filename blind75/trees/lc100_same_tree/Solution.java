package blind75.trees.lc100_same_tree;

import data_structures.TreeNode;

public class Solution {
    /**
     * Given the roots of two binary trees p and q, write a function to check if
     * they are the same or not.
     * 
     * Two binary trees are considered the same if they are structurally identical,
     * and the nodes have the same value.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;
        boolean isSameLeft = isSame(node1.left, node2.left);
        boolean isSameRight = isSame(node1.right, node2.right);

        return (isSameLeft && isSameRight);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode sample = TreeNode.createSampleTreeNode();
        TreeNode sampleDiff = new TreeNode(1);
        sampleDiff.left = new TreeNode(2);
        sampleDiff.right = new TreeNode(3);
        sampleDiff.left.left = new TreeNode(4);

        System.out.println(sol.isSameTree(sample, sample)); // expected: true
        System.out.println(sol.isSameTree(sample, sampleDiff)); // expected: false
    }
}
