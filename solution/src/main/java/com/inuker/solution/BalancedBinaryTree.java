package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/28.
 */

/**
 * 平衡二叉树条件是左边是平衡，右边是平衡，且两边高度差相差不超过1
 * 树的高度是所有子树的最大高度
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
