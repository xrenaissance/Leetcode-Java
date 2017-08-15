package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/21.
 */

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        int[] count = new int[1];
        pathSum(root, sum, count);
        return count[0];
    }

    private void pathSum(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }

        pathSumWithRoot(root, sum, count);

        pathSum(root.left, sum, count);
        pathSum(root.right, sum, count);
    }

    private void pathSumWithRoot(TreeNode root, int sum, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count[0]++;
        }
        pathSumWithRoot(root.left, sum - root.val, count);
        pathSumWithRoot(root.right, sum - root.val, count);
    }
}
