package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/18.
 */

public class PaintHouse {

    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int[] f0 = new int[n];
        int[] f1 = new int[n];
        int[] f2 = new int[n];
        for (int i = 0; i < costs.length; i++) {
            f0[i] = (i > 0 ? Math.min(f1[i - 1], f2[i - 1]) : 0) + costs[i][0];
            f1[i] = (i > 0 ? Math.min(f0[i - 1], f2[i - 1]) : 0) + costs[i][1];
            f2[i] = (i > 0 ? Math.min(f0[i - 1], f1[i - 1]) : 0) + costs[i][2];
        }
        int min = Math.min(f0[n - 1], f1[n - 1]);
        return Math.min(min, f2[n - 1]);
    }
}
