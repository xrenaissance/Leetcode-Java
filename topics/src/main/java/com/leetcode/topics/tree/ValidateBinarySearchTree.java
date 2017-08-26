package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

/**
 * Created by dingjikerbo on 2017/7/19.
 */

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST(TreeNode root, long down, long up) {
        if (root == null) {
            return true;
        }
        return root.val > down && root.val < up
                && isValidBST(root.left, down, root.val)
                && isValidBST(root.right, root.val, up);
    }
}
