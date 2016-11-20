package com.inuker.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class MergeKSortedList {

    // 耗时296ms，超时了
    // 时间为2k + 3k + 4k + ... + nk
    // 时间复杂度O(n^2 * k)，n为链表条数，k为链表平均长度
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (ListNode node : lists) {
            head = mergeTwoLists(head, node);
        }
        return head;
    }

    private ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for ( ; nodeA != null && nodeB != null; ) {
            if (nodeA.val < nodeB.val) {
                cur.next = nodeA;
                nodeA = nodeA.next;
            } else {
                cur.next = nodeB;
                nodeB = nodeB.next;
            }
            cur = cur.next;
        }
        cur.next = nodeA != null ? nodeA : nodeB;
        return dummy.next;
    }

    // 耗时23ms
    // 时间复杂度为O(knlgn)
    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? 1 : -1;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0), cur = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();

            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return dummy.next;
    }

    // 耗时18ms，比前两种方法都快
    // T(n)=2T(n/2)+kn，时间复杂度为O(knlgn)
    public ListNode mergeKLists3(ListNode[] lists) {
        return mergeKLists3(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists3(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start > end) {
            return null;
        } else {
            int mid = start + ((end - start) >>> 1);
            return mergeTwoLists(mergeKLists3(lists, start, mid), mergeKLists3(lists, mid + 1, end));
        }
    }
}
