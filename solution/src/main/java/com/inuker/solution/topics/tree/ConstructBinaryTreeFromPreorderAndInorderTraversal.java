package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/15.
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int i = 1;
        for ( ; i <= preEnd - preStart; i++) {
            if (inorder[inStart + i - 1] == preorder[preStart]) {
                break;
            }
        }

        root.left = buildTree(preorder, preStart + 1, preStart + i, inorder, inStart, inStart + i);
        root.right = buildTree(preorder, preStart + i, preEnd, inorder, inStart + i, inEnd);
        return root;
    }
}
