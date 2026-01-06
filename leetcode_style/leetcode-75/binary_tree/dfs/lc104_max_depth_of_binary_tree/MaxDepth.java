package binary_tree.dfs.lc104_max_depth_of_binary_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepth {
    /*
     * Given the root of a binary tree, return its maximum depth.
     * 
     * A binary tree's maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return 1 + Math.max(maxDepth(left), maxDepth(right));
    }

    public static void main(String[] args) {
        MaxDepth md = new MaxDepth();
        String output = "Output: ";

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(output + md.maxDepth(root1));
    }
}
