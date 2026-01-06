package binary_tree.bfs.lc1161_maximum_level_sum_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import data_structures.TreeNode;

public class MaxLevelSum {
    /*
     * Given the root of a binary tree, the level of its root is 1, the level of its
     * children is 2, and so on.
     * 
     * Return the smallest level x such that the sum of all the values of nodes at
     * level x is maximal.
     */
    public int maxLevelSum(TreeNode root) {
        return findMaxLevelSum(root);
    }

    private int findMaxLevelSum(TreeNode node) {
        if(node == null) return 0;

        Queue<TreeNode> levels = new LinkedList<>();
        levels.offer(node);
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = 0;
        while (!levels.isEmpty()) {
            int levelSize = levels.size();
            int currentSum = 0;
            level++;

            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = levels.poll();
                currentSum += currentNode.val;

                if(currentNode.left != null) levels.offer(currentNode.left);
                if(currentNode.right != null) levels.offer(currentNode.right);
            }

            if(currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        MaxLevelSum mls = new MaxLevelSum();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(-8);
        root1.right.left = null;
        root1.right.right = null;

        System.out.println(output + mls.maxLevelSum(root1));
    }
}
