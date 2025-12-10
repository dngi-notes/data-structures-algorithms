package random_leetcode.traversals.level_order;

import java.util.*;
import data_structures.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelTraversal = new ArrayList<>();
        if (root == null) return levelTraversal;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (level.size() == size) {
                levelTraversal.add(level);
            }
        }

        return levelTraversal;
    }
    
    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode root = TreeNode.createSampleTreeNode();

        System.out.println(ss.levelOrder(root));
    }
}
