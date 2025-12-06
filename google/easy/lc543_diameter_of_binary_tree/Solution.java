package google.easy.lc543_diameter_of_binary_tree;

import data_structures.TreeNode;

/**
 * given the root of a binary tree, return the length of the diameter of the
 * tree
 */
public class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getTreeHeight(root);
        return diameter;
    }

    private int getTreeHeight(TreeNode node) {
        if (node == null) return 0;

        int leftPath = getTreeHeight(node.left);
        int rightPath = getTreeHeight(node.right);

        diameter = (leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(sol.diameterOfBinaryTree(root)); // expected: 3
    }
}
