package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 17/1/2.
 */

/**
 * 题目中已声明不会有重复的边，类似[0,1]和[1,0]认为是重复的，也不会同时存在
 */

/**
 * 这题就是给了一堆边，看这些边构成的有向图会不会有环，另外这些边是不是都连在一起的
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

            /**
             * 既然题目中已经说明不会有重复的边，所以如果x==y说明x和y已经有一条路径相通了，
             * 如果再多一条路径就要构成环了，所以这里直接return false
             */
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
