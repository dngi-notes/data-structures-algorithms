package binary_tree.dfs.lc236_lowest_common_ancestor_of_a_binary_tree;

import data_structures.TreeNode;

public class LowestCommonAncestor {
    /*
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
     * in the tree.
     * 
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor
     * is defined between two nodes p and q as the lowest node in T that has both p
     * and q as descendants (where we allow a node to be a descendant of itself).”
     * 
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the tree.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();

        // Construct the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Test cases
        TreeNode p = root.left; // Node 5
        TreeNode q = root.right; // Node 1
        TreeNode ancestor = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 1: " + (ancestor != null ? ancestor.val : "null")); // Expected: 3

        p = root.left; // Node 5
        q = root.left.right.right; // Node 4
        ancestor = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 5 and 4: " + (ancestor != null ? ancestor.val : "null")); // Expected: 5

        p = root.left.left; // Node 6
        q = root.left.right.left; // Node 7
        ancestor = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 6 and 7: " + (ancestor != null ? ancestor.val : "null")); // Expected: 5

        p = root.right.left; // Node 0
        q = root.right.right; // Node 8
        ancestor = lca.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 0 and 8: " + (ancestor != null ? ancestor.val : "null")); // Expected: 1
    }
}
