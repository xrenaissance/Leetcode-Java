package com.inuker.solution.tree;

import com.inuker.solution.TreeNode;

import java.util.Stack;

/**
 * Created by liwentian on 17/7/17.
 */

public class RecoverBinarySearchTree {

    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root);
        if (first != null && second != null) {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }

    private void inorderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (prev != null) {
                    if (first == null && root.val < prev.val) {
                        first = prev;
                    }

                    if (first != null && root.val < prev.val) {
                        second = root;
                    }
                }

                prev = root;

                root = root.right;
            }
        }
    }
}
