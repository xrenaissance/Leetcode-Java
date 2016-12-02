package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/2.
 */

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double min = Double.MAX_VALUE;

        for (TreeNode p = root; p != null; ) {
            double gap = Math.abs(target - p.val);
            if (gap < min) {
                min = gap;
                closest = p.val;
            }

            if (target > p.val) {
                p = p.right;
            } else if (target < p.val) {
                p = p.left;
            } else {
                break;
            }
        }

        return closest;
    }
}
