package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/14.
 */

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.right, right.left)
                && isSymmetric(left.left, right.right);
    }
}
