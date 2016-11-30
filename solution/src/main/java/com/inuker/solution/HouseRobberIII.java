package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/1.
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
