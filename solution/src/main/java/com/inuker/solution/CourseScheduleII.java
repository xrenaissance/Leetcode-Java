package com.inuker.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class CourseScheduleII {

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
            /**
             * 这里要避免添加多次
             */
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
