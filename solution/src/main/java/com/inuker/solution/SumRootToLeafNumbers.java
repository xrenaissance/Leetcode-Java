package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/2.
 */

public class SumRootToLeafNumbers {

    private class Sum {
        int val;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Sum sum = new Sum();
        Sum temp = new Sum();
        temp.val = root.val;
        sumNumbers(root, sum, temp);
        return sum.val;
    }

    private void sumNumbers(TreeNode root, Sum sum, Sum temp) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum.val += temp.val;
            return;
        }

        if (root.left != null) {
            temp.val = temp.val * 10 + root.left.val;
            sumNumbers(root.left, sum, temp);
            temp.val = temp.val / 10;
        }

        if (root.right != null) {
            temp.val = temp.val * 10 + root.right.val;
            sumNumbers(root.right, sum, temp);
            temp.val = temp.val / 10;
        }
    }
}
