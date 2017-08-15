package com.inuker.solution.snapchat;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/8/15.
 */

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        double minDelta = Double.MAX_VALUE;

        int value = 0;

        while (root != null) {
            double delta = Math.abs(target - root.val);

            if (delta < minDelta) {
                minDelta = delta;
                value = root.val;
            }

            if (target > root.val) {
                root = root.right;
            } else if (target < root.val) {
                root = root.left;
            } else {
                break;
            }
        }

        return value;
    }
}
