package amazon.easy.lc543_diamter_of_binary_tree;

import data_structures.TreeNode;

/*
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTree {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println(output + dbt.diameterOfBinaryTree(root1)); // expected 3


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println(output + dbt.diameterOfBinaryTree(root2)); // expected 1

    }
}
