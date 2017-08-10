package com.inuker.solution.amazon;

import com.inuker.solution.ListNode;

/**
 * Created by liwentian on 17/8/10.
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);

        for (ListNode node = head; node != null; ) {
            ListNode next = node.next;

            node.next = dummy.next;
            dummy.next = node;

            node = next;
        }

        return dummy.next;
    }
}
