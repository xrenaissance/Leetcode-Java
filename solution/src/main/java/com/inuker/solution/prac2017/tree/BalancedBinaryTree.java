package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/12.
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, null);
    }

    private boolean isBalanced(TreeNode root, int[] height) {
        if (root == null) {
            return true;
        }

        int[] left = new int[1], right = new int[1];
        boolean result = isBalanced(root.left, left) && isBalanced(root.right, right);

        if (height != null) {
            height[0] = Math.max(left[0], right[0]) + 1;
        }

        return result && Math.abs(left[0] - right[0]) <= 1;
    }
}
