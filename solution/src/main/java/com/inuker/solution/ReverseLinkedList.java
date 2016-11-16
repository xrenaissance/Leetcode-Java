package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class ReverseLinkedList {

    // 耗时0ms
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);

        for (ListNode p = head; p != null; ) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }

        return dummy.next;
    }

    // 耗时30ms，这里耗时是因为要遍历到链表末尾
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode rev = reverseList2(head.next), p = rev;
        for ( ; p.next != null; p = p.next);
        p.next = head;
        head.next = null;

        return rev;
    }

    // 耗时1ms
    public ListNode reverseList3(ListNode head) {
        ListNode[] nodes = new ListNode[2];
        reverseList3(head, nodes);
        return nodes[0];
    }

    private void reverseList3(ListNode head, ListNode[] nodes) {
        if (head == null) {
            Arrays.fill(nodes, null);
            return;
        }

        if (head.next == null) {
            Arrays.fill(nodes, head);
            return;
        }

        ListNode[] next = new ListNode[2];
        reverseList3(head.next, next);

        next[1].next = head;
        head.next = null;

        nodes[0] = next[0];
        nodes[1] = head;
    }
}
