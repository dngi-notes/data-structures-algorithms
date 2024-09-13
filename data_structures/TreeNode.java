package data_structures;

/**
 * The {@code TreeNode} class represents a node in a binary tree.
 * Each node contains an integer value, a reference to the left child, 
 * and a reference to the right child.
 * This class can be used to construct binary trees for various tree-based algorithms.
 */
public class TreeNode {
    /**
     * The value stored in the node.
     */
    public int val;

    /**
     * The left child node.
     */
    public TreeNode left;

    /**
     * The right child node.
     */
    public TreeNode right;

    /**
     * Constructs an empty {@code TreeNode}.
     */
    public TreeNode() {
    }

    /**
     * Constructs a {@code TreeNode} with the specified value and no children.
     *
     * @param val the value to be stored in the node
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructs a {@code TreeNode} with the specified value and child nodes.
     *
     * @param val   the value to be stored in the node
     * @param left  the left child node
     * @param right the right child node
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Returns a string representation of the {@code TreeNode}.
     * The format is: val -> (left child, right child).
     * If a child is null, it is represented as "null".
     *
     * @return a string representation of the {@code TreeNode}
     */
    @Override
    public String toString() {
        String leftStr = (left == null) ? "null" : left.toString();
        String rightStr = (right == null) ? "null" : right.toString();
        return val + " -> (" + leftStr + ", " + rightStr + ")";
    }
}
