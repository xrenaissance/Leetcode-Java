package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/30.
 */

public class RecoverBinarySearchTree {

    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

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

            if (first != null && node.val < prev.val) {
                second = node;
            }
        }

        prev = node;

        inorderTraversal(node.right);
    }
}
