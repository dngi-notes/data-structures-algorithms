package binary_tree.dfs.lc872_leaf_similar_trees;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
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
}