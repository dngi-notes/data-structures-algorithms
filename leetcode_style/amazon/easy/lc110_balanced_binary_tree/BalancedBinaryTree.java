package amazon.easy.lc110_balanced_binary_tree;

import data_structures.TreeNode;

public class BalancedBinaryTree {
    /*
     * Given a binary tree, determine if it is height-balanced
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println(output + bbt.isBalanced(root1)); // expected true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        System.out.println(output + bbt.isBalanced(root2)); // expected false

        TreeNode root3 = null;
        System.out.println(output + bbt.isBalanced(root3)); // expected true

    }
}

