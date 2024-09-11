package binary_tree.dfs.lc437_path_sum_3;

import data_structures.TreeNode;
import java.util.Map;
import java.util.HashMap;

public class PathSum {
    /*
     * Given the root of a binary tree and an integer targetSum, return the number
     * of paths where the sum of the values along the path equals targetSum.
     * 
     * The path does not need to start or end at the root or a leaf, but it must go
     * downwards (i.e., traveling only from parent nodes to child nodes).
     * 
     * Constraints:
     * 
     * The number of nodes in the tree is in the range [0, 1000].
     * -109 <= Node.val <= 109
     * -1000 <= targetSum <= 1000
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);

        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;

        int numPathsToCurr = prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        int numPathsLeft = dfs(node.left, currentSum, targetSum, prefixSumMap);
        int numPathsRight = dfs(node.right, currentSum, targetSum, prefixSumMap);

        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return numPathsToCurr + numPathsLeft + numPathsRight;
    }

    public static void main(String[] args) {
        PathSum ps = new PathSum();
        String output = "Output: ";

        /* root = [10, 5, -3, 3, 2, null, 11, 3, -2, null, 1] */
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.left = null;
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.left = null;
        root1.left.right.right = new TreeNode(1);

        System.out.println(output + ps.pathSum(root1, 8)); // expected 3
    }
}