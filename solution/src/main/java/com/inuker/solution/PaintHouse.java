package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/18.
 */

public class PaintHouse {

    public int minCost(int[][] costs) {
        int row = costs.length;

        if (row == 0) {
            return 0;
        }

        int[][] f = new int[row][3];

        for (int i = 0; i < row; i++) {
            f[i][0] = costs[i][0] + (i > 0 ? Math.min(f[i - 1][1], f[i - 1][2]) : 0);
            f[i][1] = costs[i][1] + (i > 0 ? Math.min(f[i - 1][0], f[i - 1][2]) : 0);
            f[i][2] = costs[i][2] + (i > 0 ? Math.min(f[i - 1][0], f[i - 1][1]) : 0);
        }

        int min = Math.min(f[row - 1][0], f[row - 1][1]);
        return Math.min(min, f[row - 1][2]);
    }
}
