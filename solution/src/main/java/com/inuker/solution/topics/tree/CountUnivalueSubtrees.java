package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/23.
 */

public class CountUnivalueSubtrees {

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        countUnivalSubtrees(root, count);
        return count[0];
    }

    private boolean countUnivalSubtrees(TreeNode root, int[] count) {
        if (root == null) {
            // 这里要返回true，想想为什么
            return true;
        }

        boolean flag1 = countUnivalSubtrees(root.left, count);
        boolean flag2 = countUnivalSubtrees(root.right, count);

        if (flag1 && flag2) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }

            if (root.right != null && root.val != root.right.val) {
                return false;
            }

            count[0]++;
            return true;
        }

        return false;
    }
}
