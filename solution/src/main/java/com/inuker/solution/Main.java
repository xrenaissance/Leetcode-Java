package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int len = new MaximumSizeSubarraySumEqualsK().maxSubArrayLen2(new int[] {
             1, 0, -1
        }, 1);
        System.out.println(len);
    }

    private static ListNode make(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}
