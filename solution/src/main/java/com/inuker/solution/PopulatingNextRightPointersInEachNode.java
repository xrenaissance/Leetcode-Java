package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        for ( ; root != null; root = root.left) {
            TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
            for (TreeLinkNode node = root; node != null && node.left != null && node.right != null; node = node.next) {
                cur.next = node.left;
                cur.next.next = node.right;
                cur = cur.next.next;
            }
            cur.next = null;
        }
    }
}
