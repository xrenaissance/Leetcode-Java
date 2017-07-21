package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/21.
 */

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        TreeNode closestNode = null;
        double closest = Double.MAX_VALUE;
        for (TreeNode node = root; node != null; ) {
            double gap = Math.abs(target - node.val);
            if (gap < closest) {
                closest = gap;
                closestNode = node;
            }

            if (gap < 0.001) {
                return node.val;
            } else if (target > node.val) {
                node = node.right;
            } else if (target < node.val) {
                node = node.left;
            }
        }
        return closestNode.val;
    }
}
