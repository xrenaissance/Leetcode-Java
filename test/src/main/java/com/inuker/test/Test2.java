package com.inuker.test;

import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.TreeMap;

/**
 * Created by liwentian on 2017/12/5.
 */

public class Test2 {

    public int countComponents2(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(graph, i, visited);
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] graph, int i, Set<Integer> visited) {
        if (!visited.add(i)) {
            return;
        }
        for (Integer k : graph[i]) {
            dfs(graph, k, visited);
        }
    }
}
