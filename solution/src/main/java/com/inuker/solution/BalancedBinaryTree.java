package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/28.
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }

    private boolean isBalanced(TreeNode root, int[] height) {
        if (root == null) {
            height[0] = 0;
            return true;
        } else {
            int[] leftHeight = new int[1], rightHeight = new int[1];
            boolean left = isBalanced(root.left, leftHeight);
            boolean right = isBalanced(root.right, rightHeight);
            height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
            return left && right && Math.abs(leftHeight[0] - rightHeight[0]) <= 1;
        }
    }
}
