package com.inuker.solution.tree;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liwentian on 17/8/4.
 */

public class LRUCache {

    private HashMap<Integer, ListNode> mMap;
    private int mCapacity;

    private ListNode mHead;

    public LRUCache(int capacity) {
        mMap = new HashMap<>();
        mCapacity = capacity;
        mHead = new ListNode(0, 0);
    }

    public int get(int key) {
        if (mMap.containsKey(key)) {
            ListNode node = mMap.get(key);
            node.remove();
            mHead.add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (mMap.containsKey(key)) {
            ListNode node = mMap.get(key);
            node.remove();
            mHead.add(node);
            node.val = value;
        } else {
            if (mMap.size() == mCapacity) {
                ListNode node = mHead.prev;
                mMap.remove(node.key);
                node.remove();
            }
            ListNode node = new ListNode(key, value);
            mHead.add(node);
            mMap.put(key, node);
        }
    }

    private class ListNode {
        ListNode prev;
        ListNode next;

        int key;
        int val;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            prev = this;
            next = this;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }

        void add(ListNode node) {
            node.next = next;
            next.prev = node;

            node.prev = this;
            this.next = node;
        }
    }
}
