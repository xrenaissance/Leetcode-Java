package com.inuker.solution.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dingjikerbo on 2016/11/16.
 * https://leetcode.com/problems/lru-cache/
 */

/** Test Cases
LRUCache cache = new LRUCache(1);
cache.set(2, 1);
System.out.println(cache.get(2));
cache.set(3,2);
System.out.println(cache.get(2));
System.out.println(cache.get(3));
 */
public class LRUCache {

    private int mCapacity;

    private Map<Integer, DNode> mMap;

    private DNode mHead;

    public LRUCache(int capacity) {
        mCapacity = capacity;
        mMap = new HashMap<Integer, DNode>();

        mHead = new DNode();
        mHead.prev = mHead;
        mHead.next = mHead;
    }

    public int get(Integer key) {
        if (!mMap.containsKey(key)) {
            return -1;
        }

        DNode node = mMap.get(key);
        node.remove();
        node.addAfter(mHead);
        return node.val;
    }

    public void set(Integer key, int value) {
        if (mMap.containsKey(key)) {
            DNode node = mMap.get(key);
            node.val = value;

            node.remove();
            node.addAfter(mHead);
        } else {
            DNode node = new DNode(key, value);
            mMap.put(key, node);
            node.addAfter(mHead);

            if (mMap.size() > mCapacity) {
                DNode old = mHead.prev;
                mMap.remove(old.key);
                old.remove();
            }
        }
    }
}

class DNode {
    DNode prev, next;
    int key, val;

    DNode() {

    }

    DNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    void remove() {
        prev.next = next;
        next.prev = prev;
    }

    void addAfter(DNode node) {
        next = node.next;
        node.next.prev = this;

        prev = node;
        node.next = this;
    }
}

/*
public class LRUCache {
    private Map<Integer, Integer> mMap;

    private int mCapacity;

    public LRUCache(int capacity) {
        mCapacity = capacity;

        // 第三个参数true表示用accessOrder排序
        mMap = new LinkedHashMap<Integer, Integer>(mCapacity, 0.5f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return mMap.size() > mCapacity;
            }
        };
    }

    // 这里不能直接返回get(key)，可能会抛NPR
    public int get(Integer key) {
        if (mMap.containsKey(key)) {
            return mMap.get(key);
        } else {
            return -1;
        }
    }

    public void set(Integer key, int value) {
        mMap.put(key, value);
    }
}
*/