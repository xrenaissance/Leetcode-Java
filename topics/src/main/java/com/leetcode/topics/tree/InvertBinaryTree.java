package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

/**
 * Created by liwentian on 17/7/11.
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode node = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(node);
        return root;
    }
}
