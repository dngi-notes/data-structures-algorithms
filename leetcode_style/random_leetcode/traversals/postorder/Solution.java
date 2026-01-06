package random_leetcode.traversals.postorder;

import java.util.*;
import data_structures.TreeNode;

public class Solution {
    public List<Integer> getPostorder(TreeNode root) {
        List<Integer> poTrav = new ArrayList<>();
        postorder(root, poTrav);
        return poTrav;
    }

    private void postorder(TreeNode node, List<Integer> poTrav) {
        if (node == null) return;

        postorder(node.left, poTrav);
        postorder(node.right, poTrav);
        poTrav.add(node.val);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode root = TreeNode.createSampleTreeNode();
        root.right.left = new TreeNode(4);
        System.out.println(ss.getPostorder(root)); // expected 2, 4, 3, 1
    }
}