package blind75.trees.lc104_maximum_depth_of_binary_tree;

import data_structures.TreeNode;

public class Solution {
    /**
     * Given the root of a binary tree, return its maximum depth.
     * 
     * A binary tree's maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        return calculateMaxDepth(root);
    }

    private int calculateMaxDepth(TreeNode node) {
        if (node == null) return 0;

        int leftPath = calculateMaxDepth(node.left);
        int rightPath = calculateMaxDepth(node.right);

        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode sample = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        sample.right.left = new TreeNode(15);
        sample.right.right = new TreeNode(7);

        System.out.println(sol.maxDepth(sample)); // expected: 3
    }
}
