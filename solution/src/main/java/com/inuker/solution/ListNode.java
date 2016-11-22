package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode make(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}
