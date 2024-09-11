package binary_tree.dfs.lc1372_longest_zigzag_path_in_binary_tree;

import data_structures.TreeNode;

public class LongestZigZag {
    /*
     * You are given the root of a binary tree.
     * 
     * A ZigZag path for a binary tree is defined as follow:
     * 
     * Choose any node in the binary tree and a direction (right or left).
     * If the current direction is right, move to the right child of the current
     * node; otherwise, move to the left child.
     * Change the direction from right to left or from left to right.
     * Repeat the second and third steps until you can't move in the tree.
     * Zigzag length is defined as the number of nodes visited - 1. (A single node
     * has a length of 0).
     * 
     * Return the longest ZigZag path contained in that tree.
     */
    public int longestZigZag(TreeNode root) {
        return calculateZigZag(root, false, 0);
    }

    private int calculateZigZag(TreeNode node, boolean isRight, int length) {
        if (node == null) {
            return length - 1;
        }

        int leftZigZag = calculateZigZag(node.left, false, isRight ? length + 1 : 1);
        int rightZigZag = calculateZigZag(node.right, true, isRight ? 1 : length + 1);

        return Math.max(leftZigZag, rightZigZag);
    }

    /*
     * Time Complexity: O(n)
     * Space Compleity: O(h)
     */

    public static void main(String[] args) {
        LongestZigZag lzz = new LongestZigZag();
        String output = "Output: ";

        // Test case 1: Single node tree
        TreeNode root1 = new TreeNode(1);
        System.out.println(output + lzz.longestZigZag(root1)); // Expected: 0

        // Test case 2: Zigzag path
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.left.right.left = new TreeNode(4);
        System.out.println(output + lzz.longestZigZag(root2)); // Expected: 3

        // Test case 3: No zigzag path
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        System.out.println(output + lzz.longestZigZag(root3)); // Expected: 1

        // Test case 4: Mixed tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.right = new TreeNode(4);
        root4.right.left = new TreeNode(5);
        root4.right.left.right = new TreeNode(6);
        System.out.println(output + lzz.longestZigZag(root4)); // Expected: 3
    }
}
