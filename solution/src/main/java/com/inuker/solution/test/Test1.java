package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        for (ListNode p = head; p != null; p = p.next, count++);
        ListNode dummy = new ListNode(0), cur = dummy;
        for (ListNode p = head; p != null; ) {
            if (count >= k) {
                for (int i = 0; i < k; i++) {
                    ListNode next = p.next;
                    p.next = cur.next;
                    cur.next = p;
                    p = next;
                }
                count -= k;
            } else {
                cur.next = p;
                break;
            }
        }
        return dummy.next;
    }
}
