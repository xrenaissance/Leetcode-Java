package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/23.
 */

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
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
