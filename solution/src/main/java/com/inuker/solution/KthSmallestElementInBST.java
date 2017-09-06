package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/30.
 */

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        int[] kth = new int[1];
        inorderTraversal(root, k, kth);
        return kth[0];
    }

    private int inorderTraversal(TreeNode root, int k, int[] kth) {
        if (root == null) {
            return k;
        }

        k = inorderTraversal(root.left, k, kth);

        if (--k == 0) {
            kth[0] = root.val;
            return 0;
        }

        return inorderTraversal(root.right, k, kth);
    }

    /**
     * 非递归法
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
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
