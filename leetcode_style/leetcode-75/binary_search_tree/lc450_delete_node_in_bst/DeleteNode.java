package binary_search_tree.lc450_delete_node_in_bst;

import data_structures.TreeNode;

public class DeleteNode {
    /*
     * Given a root node reference of a BST and a key, delete the node with the
     * given key in the BST. Return the root node reference (possibly updated) of
     * the BST.
     * 
     * Basically, the deletion can be divided into two stages:
     * 
     * 1. Search for a node to remove.
     * 2. If the node is found, delete the node.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            root.val = findMinValue(root.left);
            root.left = deleteNode(root.left, root.val);
        }

        return root;
    }

    private int findMinValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            root = root.left;
            minValue = root.val;
        }

        return minValue;
    }

    /*
     * Time Complexity: O(h), where h can be either O(n) if the tree is unbalanced and O(logn) if it is balanced
     * Space Complexity: O(h)
     */

    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.left = null;
        root1.right.right = new TreeNode(7);
        System.out.println(output + dn.deleteNode(root1, 3).toString());
        ;
    }
}