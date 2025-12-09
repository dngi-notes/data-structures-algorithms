package random_leetcode.traversals.preorder;

import java.util.*;
import data_structures.TreeNode;

class Solution {
    private List<Integer> pTrav;

    public List<Integer> getPreorder(TreeNode root) {
        pTrav = new ArrayList<>();
        preorder(root);
        return pTrav;
    }

    private void preorder(TreeNode node) {
        if (node == null)
            return;
        pTrav.add(node.val);

        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.createSampleTreeNode();
        root.left.left = new TreeNode(4);

        System.out.println(sol.getPreorder(root));
    }
}
