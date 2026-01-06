package amazon.easy.lc104_maximum_depth_of_binary_tree;

import data_structures.TreeNode;

public class MaximumDepth {
    /*
     * Given the root of a binary tree, return its maximum depth.
     * 
     * A binary tree's maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     */

    public int maxDepth(TreeNode root) {
        return calculateMaxDepth(root);
    }

    private int calculateMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = calculateMaxDepth(node.left);
        int rightDepth = calculateMaxDepth(node.right);

        int maxDepth = Math.max(leftDepth, rightDepth) + 1;
        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumDepth md = new MaximumDepth();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(output + md.maxDepth(root1)); // expected: 2

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(20);
        root2.right.right = new TreeNode(7);
        System.out.println(output + md.maxDepth(root2)); // expected 3
    }
}