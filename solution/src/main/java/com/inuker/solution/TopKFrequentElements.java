package com.inuker.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by dingjikerbo on 16/12/10.
 */

public class TopKFrequentElements {

    // 耗时46ms，最差复杂度O(nlgn)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int key : map.keySet()) {
            queue.add(new int[] { key, map.get(key) });
        }
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= k && !queue.isEmpty(); i++) {
            list.add(queue.poll()[0]);
        }
        return list;
    }

    // 耗时23ms，复杂度O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] lists = new LinkedList[nums.length + 1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (lists[count] == null) {
                lists[count] = new LinkedList<Integer>();
            }
            lists[count].add(key);
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = lists.length - 1; i >= 0 && result.size() < k; i--) {
            if (lists[i] != null) {
                result.addAll(lists[i]);
            }
        }
        return result;
    }
}
