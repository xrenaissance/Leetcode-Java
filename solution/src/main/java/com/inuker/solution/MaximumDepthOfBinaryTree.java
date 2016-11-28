package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/28.
 */

public class MaximumDepthOfBinaryTree {

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
