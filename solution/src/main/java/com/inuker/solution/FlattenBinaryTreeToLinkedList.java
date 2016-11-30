package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/30.
 */

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode right = root.right;
        TreeNode leftTail = null, rightTail = null;

        if (root.left != null) {
            leftTail = helper(root.left);
            root.right = root.left;
            leftTail.right = right;
            root.left = null;
        }

        rightTail = helper(root.right);

        return rightTail != null ? rightTail : leftTail;
    }
}
