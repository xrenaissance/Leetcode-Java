package com.inuker.solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 17/1/2.
 */

/**
 * http://bookshadow.com/weblog/2016/11/22/leetcode-lfu-cache/
 */
public class LFUCache {

    private int cap = 0;

    /**
     * key为查询的键，得到对应的value，因为每个node下只保留keys，所以values存在这
     */
    private HashMap<Integer, Integer> values = null;

    /**
     * key为查询的键，通过key得到对应的node
     */
    private HashMap<Integer, Node> nodes = null;

    /**
     * head是双向链表，每个Node对应一个次数，其下挂载了keys
     */
    private Node head;

    public LFUCache(int capacity) {
        this.cap = capacity;
        head = new Node(0);
        values = new HashMap<Integer, Integer>();
        nodes = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (values.containsKey(key)) {
            increaseCount(key);
            return values.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cap == 0) return;
        if (values.containsKey(key)) {
            values.put(key, value);
        } else {
            if (values.size() >= cap) {
                removeOld();
            }
            values.put(key, value);
            /**
             * head对应的是0次，这里先暂加到head中，下面再increaseCount
             */
            head.keys.add(key);
            nodes.put(key, head);
        }
        increaseCount(key);
    }

    private void increaseCount(int key) {
        Node node = nodes.get(key);
        node.keys.remove(key);

        Node next = node.next;
        if (next.count == node.count + 1) {
            next.keys.add(key);
        } else {
            next = new Node(node.count + 1);
            node.addAfter(next);
            next.keys.add(key);
        }
        nodes.put(key, node.next);
        if (node.keys.isEmpty() && node != head) {
            node.remove();
        }
    }

    private void removeOld() {
        Node node = head.next;
        if (node == head) {
            return;
        }
        Integer key = node.keys.iterator().next();
        node.keys.remove(key);
        if (node.keys.isEmpty())  {
            node.remove();
        }
        nodes.remove(key);
        values.remove(key);
    }

    class Node {
        public int count;
        public LinkedHashSet<Integer> keys;
        Node next, prev;

        public Node(int count) {
            this.count = count;
            this.keys = new LinkedHashSet<>();
            next = prev = this;
        }

        public void addAfter(Node node) {
            node.next = next;
            next.prev = node;
            node.prev = this;
            next = node;
        }

        public void remove() {
            prev.next = next;
            next.prev = prev;
        }
    }
}
