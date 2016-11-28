package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/28.
 */

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        return root.val + left + right;
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(maxSum(root.left), maxSum(root.right));
        return Math.max(max, 0) + root.val;
    }
}
