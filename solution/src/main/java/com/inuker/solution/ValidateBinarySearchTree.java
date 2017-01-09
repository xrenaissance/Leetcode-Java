package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class ValidateBinarySearchTree {

    /**
     * 这要转成long
     */
    // 耗时1ms
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        return root.val > lower && root.val < upper
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}
