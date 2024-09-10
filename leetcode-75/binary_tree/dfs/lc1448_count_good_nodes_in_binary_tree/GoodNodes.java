package binary_tree.dfs.lc1448_count_good_nodes_in_binary_tree;

import data_structures.TreeNode;

public class GoodNodes {
    /*
     * Given a binary tree root, a node X in the tree is named good if in the path
     * from root to X there are no nodes with a value greater than X.
     * 
     * Return the number of good nodes in the binary tree.
     * 
     * Constraints:
     * 
     * The number of nodes in the binary tree is in the range [1, 10^5].
     * Each node's value is between [-10^4, 10^4].
     */
    public int goodNodes(TreeNode root) {
        /*
         * create a counter variable
         * traverse the left and right of each node until null
         * return the result of the search
         */
        return countGoodNodes(root, -10000);
    }

    private int countGoodNodes(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxVal) {
            count = 1;
            maxVal = node.val;
        }

        count += countGoodNodes(node.left, maxVal);
        count += countGoodNodes(node.right, maxVal);

        return count;
    }

    public static void main(String[] args) {
        GoodNodes gn = new GoodNodes();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(3);
        root1.right = null;
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(output + gn.goodNodes(root1));
    }
}
