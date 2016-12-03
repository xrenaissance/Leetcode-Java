package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/12/3.
 */

public class PathSumIII {

    /** 下面的解法有问题
    private int count;

    public int pathSum(TreeNode root, int sum) {
        helperSum(root, sum);
        return count;
    }

    private void helperSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        helper(root, sum);
        helperSum(root.left, sum);
        helperSum(root.right, sum);
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count++;
            return;
        }

        if (root.left != null) {
            helper(root.left, sum - root.val);
        }

        if (root.right != null) {
            helper(root.right, sum - root.val);
        }
    }*/
}
