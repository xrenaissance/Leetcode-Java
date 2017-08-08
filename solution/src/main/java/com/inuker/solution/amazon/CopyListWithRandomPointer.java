package com.inuker.solution.amazon;

import com.inuker.solution.RandomListNode;

import java.util.Random;

/**
 * Created by liwentian on 17/8/9.
 */

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode node = head; node != null; ) {
            RandomListNode next = node.next;

            RandomListNode copy = new RandomListNode(node.label);
            copy.next = next;
            node.next = copy;
            node = next;
        }

        for (RandomListNode node = head; node != null; ) {
            node.next.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }

        RandomListNode dummy = new RandomListNode(0), cur = dummy;
        for (RandomListNode node = head; node != null; ) {
            cur.next = node.next;
            cur = cur.next;

            node.next = node.next.next;
            node = node.next;
        }

        return dummy.next;
    }
}
