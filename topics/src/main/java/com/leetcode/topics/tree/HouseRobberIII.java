package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 17/7/23.
 */

public class HouseRobberIII {

    public int rob(TreeNode root) {
        return rob(root, true);
    }

    private int rob(TreeNode root, boolean rob) {
        if (root == null) {
            return 0;
        }

        if (rob) {
            return Math.max(root.val + rob(root.left, false) + rob(root.right, false),
                    rob(root.left, true) + rob(root.right, true));
        } else {
            return rob(root.left, true) + rob(root.right, true);
        }
    }
}
