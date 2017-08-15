package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/23.
 */

public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return node;
    }
}
