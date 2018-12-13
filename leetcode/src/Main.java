
public class Main {

    public static class Solution {

        ListNode removeDup(ListNode head) {
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

        ListNode make(int[] arr) {
            ListNode dummy = new ListNode(0), cur = dummy;
            for (int n : arr) {
                cur.next = new ListNode(n);
                cur = cur.next;
            }
            return dummy.next;
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {
                1, 3, 3, 3, 1, 2, 4, 4, 1
        };
        ListNode head = s.make(arr);
        head = s.removeDup(head);
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
    }
}
