package blind75.trees.lc235_lca_of_bst;

import data_structures.TreeNode;

public class Solution {
    /**
     * given the root of a binary search tree (BST),
     * find the lowest common ancestor (LCA) node of
     * two given nodes in the BST
     * 
     * LCA: the lowest node that has both p and q as descendants (a node can be a descendant of itself) 
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);
    }

    private TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        if (p.val < node.val && q.val < node.val) {
            return findLCA(node.left, p, q);
        } else if (p.val > node.val && q.val > node.val) {
            return findLCA(node.right, p, q);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode t = new TreeNode(6, new TreeNode(2), new TreeNode(8));
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(4);
        t.right.left = new TreeNode(7);
        t.right.right = new TreeNode(9);
        t.left.left.left = null;
        t.left.left.right = null;
        t.left.right.left = new TreeNode(3);
        t.left.right.right = new TreeNode(5);
        
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);

        System.out.println(ss.lowestCommonAncestor(t, p, q));
    }
}
