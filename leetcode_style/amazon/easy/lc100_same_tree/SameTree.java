package amazon.easy.lc100_same_tree;

import data_structures.TreeNode;

public class SameTree {
    /*
     * Given the roots of two binary trees p and q, write a function to check if
     * they are the same or not.
     * 
     * Two binary trees are considered the same if they are structurally identical,
     * and the nodes have the same value.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        boolean isSameLeft = isSame(node1.left, node2.left);
        boolean isSameRight = isSame(node1.right, node2.right);

        return (isSameLeft &&  isSameRight);
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();
        String output = "Output: ";

        TreeNode p1 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        TreeNode q1 = p1;

        System.out.println(output + st.isSameTree(p1, q1)); // expected true

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println(output + st.isSameTree(p2, q2)); // expected false

    }
}
