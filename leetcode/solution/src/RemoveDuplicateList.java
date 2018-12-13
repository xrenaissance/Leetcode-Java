public class RemoveDuplicateList {

    /**
     * 一个链表，删除相邻且重复的
     * 如 1, 3, 3, 3, 1, 2, 4, 4，只保留1, 1, 2
     */
    public ListNode removeDup(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;

        ListNode node = null;
        int count = 0;

        for (ListNode p = head; p != null; p = p.next) {
            if (node == null || node.val == p.val) {
                node = p;
                count++;
            } else {
                if (count == 1) {
                    cur.next = node;
                    cur = cur.next;
                }
                node = p;
                count = 1;
            }
        }

        if (node != null && count == 1) {
            cur.next = node;
            cur = cur.next;
        }

        cur.next = null;
        return dummy.next;
    }
}
