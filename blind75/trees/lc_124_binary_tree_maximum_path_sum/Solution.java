package blind75.trees.lc_124_binary_tree_maximum_path_sum;

import data_structures.TreeNode;

public class Solution {
    private int globalMax;
    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        getMax(root);
        return globalMax;
    }

    private int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftPathMax = Math.max(0, getMax(node.left));
        int rightPathMax = Math.max(0, getMax(node.right));

        int currentPath = node.val + leftPathMax + rightPathMax;

        globalMax = Math.max(globalMax, currentPath);

        return node.val + Math.max(leftPathMax, rightPathMax);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode sample = TreeNode.createSampleTreeNode();

        System.out.println(sample);
        System.out.println(sol.maxPathSum(sample));
    }
}
