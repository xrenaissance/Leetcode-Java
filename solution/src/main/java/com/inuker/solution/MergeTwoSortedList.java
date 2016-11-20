package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class MergeTwoSortedList {

    // 耗时15ms
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummy;
        for ( ; p != null && q != null; ) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        cur.next = p != null ? p : q;
        return dummy.next;
    }

    // 耗时14ms，这个由于没有new dummy，所以应该会比上面快一些
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
