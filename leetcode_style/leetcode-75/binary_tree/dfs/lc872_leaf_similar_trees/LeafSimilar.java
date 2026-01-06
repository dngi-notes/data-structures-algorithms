package binary_tree.dfs.lc872_leaf_similar_trees;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LeafSimilar {
    /*
     * Consider all the leaves of a binary tree, from left to right order, the
     * values of those leaves form a leaf value sequence.
     * 
     * 
     * 
     * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
     * 8).
     * 
     * Two binary trees are considered leaf-similar if their leaf value sequence is
     * the same.
     * 
     * Return true if and only if the two given trees with head nodes root1 and
     * root2 are leaf-similar.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        /*
         * no need to compare values until we reach leaf nodes (when a node has no children)
         * want to compare each leaf so the leftmost leaf in tree1 matches the leftmost in tree2 and so on
         * dfs to do that
         */
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode node, List<Integer> leaves) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            leaves.add(node.val);
        }

        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }

    public static void main(String[] args) {
        LeafSimilar ls = new LeafSimilar();
        String output = "Output: ";

        // root 1 = [3, 5, 1, 6, 2, 9, 8, null, null, 7, 4]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.left.left = null;
        root1.left.left.right = null;
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        // root2 = [3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8];
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.left.left.left = null;
        root2.left.left.right = null;
        root2.left.right.left = null;
        root2.left.right.right = null;
        root2.right.left.left = null;
        root2.right.left.right = null;
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(output + ls.leafSimilar(root1, root2));
    }
}