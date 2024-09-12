package binary_tree.bfs.lc199_binary_tree_right_side_view;

import data_structures.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class RightSideView {
    /*
     * Given the root of a binary tree, imagine yourself standing on the right side
     * of it, return the values of the nodes you can see ordered from top to bottom.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        getRightSideView(root, result);
        return result;
    }

    private void getRightSideView(TreeNode node, List<Integer> result) {
        Queue<TreeNode> rightNodes = new LinkedList<>();
        rightNodes.add(node);

        while (!rightNodes.isEmpty()) {
            int levelSize = rightNodes.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = rightNodes.poll();
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    rightNodes.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    rightNodes.add(currentNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        RightSideView rsv = new RightSideView();
        String output = "Output: ";

        // Test case 1: Original test case
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = null;
        root1.left.right = new TreeNode(5);
        root1.right.left = null;
        root1.right.right = new TreeNode(4);
        System.out.println(output + rsv.rightSideView(root1)); // Expected: [1, 3, 4]

        // Test case 2: Tree with only one node
        TreeNode root2 = new TreeNode(1);
        System.out.println(output + rsv.rightSideView(root2)); // Expected: [1]

        // Test case 3: Tree where all nodes are on the left side
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        System.out.println(output + rsv.rightSideView(root3)); // Expected: [1, 2, 3, 4]

        // Test case 4: Tree where all nodes are on the right side
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        root4.right.right.right = new TreeNode(4);
        System.out.println(output + rsv.rightSideView(root4)); // Expected: [1, 2, 3, 4]

        // Test case 5: More complex tree with multiple levels
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        root5.left.left.left = new TreeNode(8);
        root5.left.left.right = new TreeNode(9);
        System.out.println(output + rsv.rightSideView(root5)); // Expected: [1, 3, 7, 9]
    }
}
