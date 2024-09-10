package binary_tree.dfs.lc1448_count_good_nodes_in_binary_tree;

import data_structures.TreeNode;

public class GoodNodes {
    /*
     * Given a binary tree root, a node X in the tree is named good if in the path
     * from root to X there are no nodes with a value greater than X.
     * 
     * Return the number of good nodes in the binary tree.
     */
    public int goodNodes(TreeNode root) {
        /*
         * create a counter variable
         * traverse the left and right of each node until null 
         * return the result of the search
         */
        return countGoodNodes(root);
    }
    
    private int countGoodNodes(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int count = 1;

        if(node.left.val >= node.val || node.right.val >= node.val) {
            count++;
        }

        countGoodNodes(node.left);
        countGoodNodes(node.right);

        return count;
    }

    public static void main(String[] args) {
        GoodNodes gn = new GoodNodes();
        String output = "Output: ";

        TreeNode root
    }
}
