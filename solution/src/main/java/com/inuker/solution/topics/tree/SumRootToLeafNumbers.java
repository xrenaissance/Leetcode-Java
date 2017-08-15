package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/24.
 */

public class SumRootToLeafNumbers {

    private int result;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return result;
    }

    private void sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            result += sum;
            return;
        }

        sumNumbers(root.left, sum);
        sumNumbers(root.right, sum);
    }
}
