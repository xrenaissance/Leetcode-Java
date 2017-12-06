package com.inuker.test;

import com.leetcode.library.ListNode;
import com.leetcode.library.RandomListNode;
import com.leetcode.library.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode node = head; node != null; node = node.next, n++);
        ListNode dummy = new ListNode(0), cur = dummy, node = head;
        for ( ; n >= k; n -= k) {
            ListNode tail = node, next;
            for (int i = 0; i < k; i++) {
                next = node.next;
                node.next = cur.next;
                cur.next = node;
                node = next;
            }
            cur = tail;
        }
        cur.next = node;
        return dummy.next;
    }
}
