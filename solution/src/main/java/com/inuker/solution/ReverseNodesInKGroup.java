package com.inuker.solution;

import com.leetcode.library.ListNode;

/**
 * Created by dingjikerbo on 2016/11/24.
 */

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode dummy = new ListNode(0), cur = dummy, p;
        for (p = head; p != null; p = p.next, size++);

        for (p = head; size >= k; size -= k) {
            ListNode tail = p;
            for (int i = 0; i < k; i++) {
                ListNode next = p.next;
                p.next = cur.next;
                cur.next = p;
                p = next;
            }
            cur = tail;
        }
        cur.next = p;
        return dummy.next;
    }
}
