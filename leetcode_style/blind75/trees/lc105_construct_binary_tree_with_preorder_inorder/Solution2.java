package blind75.trees.lc105_construct_binary_tree_with_preorder_inorder;

import data_structures.TreeNode;
public class Solution2 {
    /**
     * You are given:
     * preorder traversal of a full binary tree (every node has 0 or 2 children)
     * inorder traversal of the same tree
     * Your task is to reconstruct the binary tree.
     * 
     * Input:
     * preorder: integer array, e.g. [1, 2, 4, 5, 3, 6, 7]
     * inorder: integer array, e.g. [4, 2, 5, 1, 6, 3, 7]
     * 
     * Assume:
     * No duplicate values
     * The tree is full (0 or 2 children for each node)
     * Arrays are valid and consistent
     * 
     * Output:
     * Return the root of the reconstructed binary tree.
     * 
     * eg.
     * in: preorder = [1, 2, 4, 5, 3, 6, 7], inorder = [4, 2, 5, 1, 6, 3, 7]
     * 
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode build(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inStart;
        for (; rootIndex < inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) break;
        }
        int leftSize = rootIndex - inStart;

        int leftPreStart = preStart + 1;
        int leftPreEnd = preStart + leftSize;
        int leftInStart = inStart;
        int leftInEnd = rootIndex - 1;
        root.left = build(leftPreStart, leftPreEnd, leftInStart, leftInEnd, preorder, inorder);

        int rightPreStart = preStart + leftSize + 1;
        int rightPreEnd = preEnd;
        int rightInStart = rootIndex + 1;
        int rightInEnd = inEnd;
        root.right = build(rightPreStart, rightPreEnd, rightInStart, rightInEnd, preorder, inorder);

        return root;
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] inorder =  new int[]{4, 2, 5, 1, 6, 3, 7};

        System.out.println(s2.buildTree(preorder, inorder));
    }
}
