package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingjikerbo on 17/1/2.
 */

public class NumberOfConnectedComponents {

    // 8ms
    public int countComponents(int n, int[][] edges) {
        int[] nums = new int[n];
        int count = n;
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x != y) {
                nums[x] = y;
                count--;
            }
        }
        return count;
    }

    private int find(int[] nums, int i) {
        for ( ; nums[i] != i; i = nums[i]);
        return i;
    }

    /**
     * DFS法
     */
    // 8ms
    public int countComponents2(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] graph, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (Integer k : graph[i]) {
            dfs(graph, k, visited);
        }
    }
}
