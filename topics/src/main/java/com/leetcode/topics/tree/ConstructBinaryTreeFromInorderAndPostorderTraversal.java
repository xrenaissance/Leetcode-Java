package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 2017/7/19.
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);

        int idx = inStart;
        for ( ; idx <= inEnd; idx++) {
            if (inorder[idx] == postorder[postEnd]) {
                break;
            }
        }

        int len = idx - inStart;
        root.left = buildTree(inorder, inStart, idx - 1, postorder, postStart, postStart + len - 1);
        root.right = buildTree(inorder, idx + 1, inEnd, postorder, postStart + len, postEnd - 1);
        return root;
    }
}
