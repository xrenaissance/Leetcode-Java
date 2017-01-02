package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/1/2.
 */

public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = i;
            count++;
        }
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            if (x != y) {
                // union
                nums[x] = y;
                count--;
            }
        }

        return count;
    }

    int find(int nums[], int i) {
        for (; nums[i] != i; i = nums[i]);
        return i;
    }
}
