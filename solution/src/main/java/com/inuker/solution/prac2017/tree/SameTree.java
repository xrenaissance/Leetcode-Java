package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/11.
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
