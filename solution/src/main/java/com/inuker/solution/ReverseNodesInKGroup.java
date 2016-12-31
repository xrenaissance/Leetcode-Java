package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/24.
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

    public ListNode reverseKGroup2(ListNode head, int k) {
        int count = 0;
        for (ListNode p = head; p != null; p = p.next, count++);
        ListNode dummy = new ListNode(0), prev = dummy, last = null;
        for (ListNode p = head; p != null; ) {
            if (count >= k) {
                for (int i = 0; i < k; i++) {
                    ListNode next = p.next;
                    p.next = prev.next;
                    prev.next = p;
                    if (last == null) {
                        last = p;
                    }
                    p = next;
                }
                count -= k;
                prev = last;
                last = null;
            } else {
                prev.next = p;
                break;
            }
        }
        return dummy.next;
    }
}
