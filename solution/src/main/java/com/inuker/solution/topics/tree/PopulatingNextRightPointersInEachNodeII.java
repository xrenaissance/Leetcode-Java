package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeLinkNode;

/**
 * Created by liwentian on 17/7/20.
 */

public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        while (root != null) {

            TreeLinkNode dummy = new TreeLinkNode(0);

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

            root = dummy.next;
        }
    }
}
