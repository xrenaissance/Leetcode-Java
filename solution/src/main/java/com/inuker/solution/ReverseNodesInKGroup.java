package com.inuker.solution;

/**
 * Created by liwentian on 2016/11/24.
 */

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int size = 0;
        ListNode dummy = new ListNode(0);
        for (ListNode p = head; p != null; p = p.next, size++);

        for (ListNode cur = dummy, p = head; p != null; ) {
            if (size < k) {
                cur.next = p;
                break;
            }
            ListNode tail = p;
            for (int i = 0; i < k; i++) {
                ListNode next = p.next;
                p.next = cur.next;
                cur.next = p;
                p = next;
            }
            size -= k;
            cur = tail;
            cur.next = null;
        }
        return dummy.next;
    }
}
