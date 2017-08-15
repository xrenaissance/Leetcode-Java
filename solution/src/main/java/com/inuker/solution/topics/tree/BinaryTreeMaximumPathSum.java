package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/13.
 */

/**
 * 有节点为负，空节点返回0，0大于负，但是0其实是无效，所以空节点应该返回INT_MIN
 * 最终返回的max中，要考虑各种可能性
 * 算单边路径时，如果左右子树都小于0，就只算根节点
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        return maxPathSum(root, null);
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] left = new int[1], right = new int[1];
        int leftMax = maxPathSum(root.left, left);
        int rightMax = maxPathSum(root.right, right);
        if (max != null) {
            max[0] = max(left[0], right[0], 0) + root.val;
        }
        return max(leftMax, rightMax, left[0] + right[0] + root.val,
                left[0] + root.val, right[0] + root.val, root.val);
    }

    private int max(int... vals) {
        int max = Integer.MIN_VALUE;
        for (int val : vals) {
            max = Math.max(max, val);
        }
        return max;
    }
}
