package random_leetcode.traversals.inorder;

import data_structures.TreeNode;
import java.util.*;

public class Solution {
    private List<Integer> inTrav;

    public List<Integer> getInorder(TreeNode root) {
        inTrav = new ArrayList<>();
        inorder(root);
        return inTrav;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        inTrav.add(node.val);
        inorder(node.right);
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode root = TreeNode.createSampleTreeNode();
        root.left.right = new TreeNode(4);

        System.out.println(ss.getInorder(root)); // expected [2, 4, 1, 3];
    }
}
