package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/11.
 */

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
