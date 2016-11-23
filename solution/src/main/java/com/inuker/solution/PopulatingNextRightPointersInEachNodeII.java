package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);

        // 注意下次循环的起始条件为dummy.next，而不是root.left或root.right，不确定是否为null
        for ( ; root != null; root = dummy.next) {
            TreeLinkNode cur = dummy;
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
            cur.next = null;
        }
    }

    /* 递归写法
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode p = dummy;
        for (TreeLinkNode cur = root; cur != null; cur = cur.next) {
            if (cur.left != null) {
                p.next = cur.left;
                p = p.next;
            }
            if (cur.right != null) {
                p.next = cur.right;
                p = p.next;
            }
        }
        p.next = null;
        connect(dummy.next);
    }
    */
}
