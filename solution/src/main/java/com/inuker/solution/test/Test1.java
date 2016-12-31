package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new LinkedList<int[]>();
        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }
        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(0);
        int prev = 0;
        List<int[]> result = new LinkedList<int[]>();
        for (int[] height : heights) {
            if (height[1] < 0) {
                queue.add(-height[1]);
            } else {
                queue.remove(height[1]);
            }
            int cur = queue.peek();
            if (prev != cur) {
                result.add(new int[] {height[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
