package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 17/1/2.
 */

/**
 * 这题要问清楚是否会有重复的边，还有[0,1]和[1,0]也会认为是重复的
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    int find(int nums[], int i) {
        for (; nums[i] != i; i = nums[i]);
        return i;
    }
}
