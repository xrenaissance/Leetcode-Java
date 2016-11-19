package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, node2, null);
        List<Integer> result = new BinaryTreeRightSideView().rightSideView(root);
        for (Integer n : result) {
            System.out.print(n + " ");
        }
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
