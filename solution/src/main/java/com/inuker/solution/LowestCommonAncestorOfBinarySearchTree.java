package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class LowestCommonAncestorOfBinarySearchTree {

    // 耗时9ms
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
