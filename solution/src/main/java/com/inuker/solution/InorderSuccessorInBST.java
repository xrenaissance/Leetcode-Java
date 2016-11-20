package com.inuker.solution;

import java.util.Stack;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class InorderSuccessorInBST {

    private boolean found;
    private TreeNode succesor;

    // 耗时5ms
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return succesor;
    }

    private void traverse(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }

        traverse(node.left, p);

        if (node == p) {
            found = true;
        } else if (found && succesor == null) {
            succesor = node;
            return;
        }

        traverse(node.right, p);
    }

    // 耗时4ms
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
