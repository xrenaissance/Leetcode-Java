package com.inuker.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        Iterator itor = map.keySet().iterator();
        while (itor.hasNext()) {
            int n = (int) itor.next();
            queue.add(new int[] { n, map.get(n) });
        }
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= k && !queue.isEmpty(); i++) {
            list.add(queue.poll()[0]);
        }
        return list;
    }
}
