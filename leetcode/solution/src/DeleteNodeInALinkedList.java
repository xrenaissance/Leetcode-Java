/**
 * Created by liwentian on 2017/9/11.
 */

/**
 * https://leetcode.com/articles/delete-node-linked-list/
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}