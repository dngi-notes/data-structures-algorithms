package blind75.trees.lc230_kth_smallest_in_bst;

import data_structures.TreeNode;

public class Solution {
    /**
     * Given the root of a binary search tree, and an integer k, return the kth
     * smallest value (1-indexed) of all the values of the nodes in the tree.
     * 
     * 
     */
    private int result = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
        }
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode tn = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        TreeNode tn1 = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        tn1.left.left = null;
        tn1.left.right = new TreeNode(2);

        System.out.println(ss.kthSmallest(tn1, 1));
    }
}
