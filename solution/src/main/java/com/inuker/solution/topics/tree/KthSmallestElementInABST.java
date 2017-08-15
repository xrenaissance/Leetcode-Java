package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

import java.util.Stack;

/**
 * Created by dingjikerbo on 2017/7/18.
 */

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (--k == 0) {
                    return root.val;
                }

                root = root.right;
            }
        }
        throw new IllegalStateException();
    }
}
