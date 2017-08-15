package com.inuker.solution.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/11.
 */

public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        for (TreeNode node = root; node != null; ) {
            if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
