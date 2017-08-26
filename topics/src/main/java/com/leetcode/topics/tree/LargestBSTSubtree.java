package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 17/8/3.
 */

/**
 * TestCase[1, 2, null]
 */
public class LargestBSTSubtree {

    private int mMax;

    public int largestBSTSubtree(TreeNode root) {
        isBST(root);
        return mMax;
    }

    private boolean isBST(TreeNode root) {
        return isBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1, new int[1]);
    }

    private boolean isBST(TreeNode root, long lower, long upper, int[] count) {
        if (root == null) {
            return true;
        }
        int[] leftcn = new int[1], rightcn = new int[1];
        boolean left = isBST(root.left, lower, root.val, leftcn);
        boolean right = isBST(root.right, root.val, upper, rightcn);

        if (left && right) {
            if (root.val > lower && root.val < upper) {
                System.out.println("isBst for " + root.val);
                count[0] = leftcn[0] + rightcn[0] + 1;
                mMax = Math.max(count[0], mMax);
                return true;
            } else {
                count[0] = Math.max(leftcn[0], rightcn[0]) + 1;
                mMax = Math.max(count[0], mMax);
                return false;
            }

        } else {
            count[0] = 0;
            return false;
        }
    }
}
