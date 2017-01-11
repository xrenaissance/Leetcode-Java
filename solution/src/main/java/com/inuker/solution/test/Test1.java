package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;
import com.inuker.solution.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            Set<Integer> set = map.get(from);
            if (set == null) {
                set = new HashSet<Integer>();
                map.put(from, set);
            }
            if (set.add(to)) {
                indegree[to]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            result[count++] = n;
            Set<Integer> set = map.get(n);
            if (set != null) {
                for (Integer k : set) {
                    if (--indegree[k] == 0) {
                        queue.add(k);
                    }
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }

}
