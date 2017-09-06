package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/30.
 */

public class RecoverBinarySearchTree {

    private TreeNode first, second, prev;

    /**
     * TestCase
     * [0, 1]是最重要且易错的
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    // 首先first是可以一次性确定的，second不能，可能要被多次覆盖，所以
    // 下面设置了second后没有立即终止，而是继续遍历，直到最后的那个才是真正的
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        if (prev != null) {
            // 两个节点交换，肯定是大的放前面了，小的放后面了，所以遇到的第一个prev大于node的，first肯定是prev.
            // 遇到的第一个node小于prev的，second肯定是node
            if (first == null && prev.val > node.val) {
                first = prev;
            }

            // 这里可否换成second == null，不能，因为second要多次覆盖
            if (first != null && prev.val > node.val) {
                second = node;
                // 这里可否加上break
            }

            // 以上两个if为何可能同时满足，参考[0,1]
        }

        prev = node;

        inorderTraversal(node.right);
    }


    // 可换成非递归的写法
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
