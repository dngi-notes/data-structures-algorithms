package binary_search_tree.lc700_search_in_a_binary_search_tree;

import data_structures.TreeNode;

public class SearchBST {
    /*
     * You are given the root of a binary search tree (BST) and an integer val.
     * 
     * Find the node in the BST that the node's value equals val and return the
     * subtree rooted with that node. If such a node does not exist, return null.
     */

    /*
     * Approach
     * Due to the nature of Binary Search Trees values less than the root are on the left, and values greater are on the right
     * so if the value we are looking for is less than the root, we can check the left
     * and if it is greater we can check the right
     * 
     */
    
    // Iterative Solution
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while(root != null) {
            if(val < root.val) {
                root = root.left;
            }
            else if(val > root.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
    //Recursive Solution
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }

        if(val < root.val) {
           return searchBSTRecursive(root.left, val);
        }

        return searchBSTRecursive(root.right, val);
    }

    public static void main(String[] args) {
        SearchBST sbst = new SearchBST();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        int val1 = 2;

        TreeNode result1 = sbst.searchBSTIterative(root1, val1);
        TreeNode result2 = sbst.searchBSTRecursive(root1, val1);
        System.out.println(output + result1);
        System.out.println(output + result2);


    }
}


