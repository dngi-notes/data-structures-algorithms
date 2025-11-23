package blind75.trees.lc102_binary_tree_level_order_traversal;

import data_structures.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }

            if (!level.isEmpty()) result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        TreeNode sample = TreeNode.createSampleTreeNode();
        System.out.println(sample);
        System.out.println(ss.levelOrder(sample));
    }
}
