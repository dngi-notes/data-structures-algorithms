package blind75.trees.lc105_construct_binary_tree_with_preorder_inorder;

import data_structures.TreeNode;

public class Solution {
    /**
     * Given two integer arrays preorder and inorder where preorder is the preorder
     * traversal of a binary tree and inorder is the inorder traversal of the same
     * tree, construct and return the binary tree.
     * 
     * Example 1:
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode build(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
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
        Solution sol = new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        System.out.println(sol.buildTree(preorder, inorder));
    }
}
