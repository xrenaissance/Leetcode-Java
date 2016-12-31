package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        for ( ; root != null; root = root.left) {
            TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
            for (TreeLinkNode node = root; node != null; node = node.next) {
                if (node.left != null) {
                    cur.next = node.left;
                    cur = cur.next;
                }

                if (node.right != null) {
                    cur.next = node.right;
                    cur = cur.next;
                }
            }
        }
    }

    /** 递归法
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
        for (TreeLinkNode p = root; p != null; p = p.next) {
            if (p.left != null) {
                cur.next = p.left;
                cur = cur.next;
            }
            if (p.right != null) {
                cur.next = p.right;
                cur = cur.next;
            }
        }
        connect(dummy.next);
    } */
}
