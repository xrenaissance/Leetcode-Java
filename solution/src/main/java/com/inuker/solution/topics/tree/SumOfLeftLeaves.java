package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/20.
 */

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        sumOfLeftLeaves(root, sum);
        return sum[0];
    }

    private void sumOfLeftLeaves(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum[0] += root.left.val;
        } else {
            sumOfLeftLeaves(root.left, sum);
        }

        sumOfLeftLeaves(root.right, sum);
    }
}
