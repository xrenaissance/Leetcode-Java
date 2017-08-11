package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 * https://leetcode.com/articles/linked-list-cycle/
 */

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next, slow = head;

        for ( ; fast != null && fast.next != null; fast = fast.next.next, slow = slow.next) {
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
