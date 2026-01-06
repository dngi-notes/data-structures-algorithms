package amazon.easy.lc226_invert_binary_tree;

import data_structures.TreeNode;

public class InvertTree {
    // Given the root of a binary tree, invert the tree, and return its root.

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val);
        node.left = invertTree(root.right);
        node.right = invertTree(root.left);

        return node;
    }

    public static void main(String[] args) {
        InvertTree it = new InvertTree();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.println(output + it.invertTree(root1));
    }
}