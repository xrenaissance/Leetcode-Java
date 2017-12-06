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

    public boolean hasCycle(ListNode head) {
        for (ListNode fast = head, slow = head; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
