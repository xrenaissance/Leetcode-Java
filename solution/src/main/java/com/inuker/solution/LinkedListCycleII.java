package com.inuker.solution;

import com.leetcode.library.ListNode;

/**
 * Created by liwentian on 2017/9/11.
 */

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode firstp = head;
        ListNode secondp = head;
        boolean isCycle = false;

        while (firstp != null && secondp != null) {
            firstp = firstp.next;
            if (secondp.next == null) return null;
            secondp = secondp.next.next;
            if (firstp == secondp) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;
        firstp = head;
        while (firstp != secondp) {
            firstp = firstp.next;
            secondp = secondp.next;
        }

        return firstp;
    }
}
