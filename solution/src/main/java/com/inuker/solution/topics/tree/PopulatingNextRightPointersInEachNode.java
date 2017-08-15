package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeLinkNode;

/**
 * Created by liwentian on 17/7/13.
 */

public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        while (root != null) {
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

            root = dummy.next;
        }
    }

    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }

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

        connect(dummy.next);
    }
}
