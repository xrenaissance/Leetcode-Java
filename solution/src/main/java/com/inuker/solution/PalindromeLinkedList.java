package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class PalindromeLinkedList {

    // 耗时2ms
    public boolean isPalindrome(ListNode head) {
        ListNode half = head;

        int len = 0;
        for (ListNode p = head; p != null && p.next != null; p = p.next.next, half = half.next) {
            len++;
        }

        half = reverse(half);

        for (int i = 0; i < len; i++, half = half.next, head = head.next) {
            if (half.val != head.val) {
                return false;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        for (ListNode p = head; p != null; ) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }
}
