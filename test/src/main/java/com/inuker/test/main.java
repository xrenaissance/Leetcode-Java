package com.inuker.test;

import com.leetcode.library.ListNode;
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


    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        for (ListNode next; head != null; head = next) {
            next = head.next;
            for (ListNode cur = dummy; cur != null; cur = cur.next) {
                if (cur.next != null && head.val > cur.next.val) {
                    continue;
                }
                head.next = cur.next;
                cur.next = head;
                break;
            }
        }
        return dummy.next;
    }

}
