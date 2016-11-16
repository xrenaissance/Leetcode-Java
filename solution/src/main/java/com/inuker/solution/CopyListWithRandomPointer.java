package com.inuker.solution;

import java.util.Random;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode p = head; p != null; ) {
            RandomListNode next = p.next;
            RandomListNode node = new RandomListNode(p.label);
            node.next = next;
            p.next = node;
            p = next;
        }

        for (RandomListNode p = head; p != null; ) {
            // 这里一定要判空
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        RandomListNode newHead = new RandomListNode(0), q = newHead;

        for (RandomListNode p = head; p != null; p = p.next) {
            RandomListNode t = p.next;
            p.next = p.next.next;

            q.next = t;
            q = q.next;
        }

        return newHead.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};
