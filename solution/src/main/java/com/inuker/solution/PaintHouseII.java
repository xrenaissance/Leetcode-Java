package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/18.
 */

public class PaintHouseII {

    // 时间复杂度O(3nk)，空间复杂度O(nk)
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int row = costs.length, col = costs[0].length;

        int[][] f = new int[row][col];

        int[] left = new int[col], right = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int minLeft = j > 0 ? left[j - 1] : Integer.MAX_VALUE;
                int minRight = j + 1 < col ? right[j + 1] : Integer.MAX_VALUE;
                f[i][j] = costs[i][j] + (i > 0 ? Math.min(minLeft, minRight) : 0);
            }
            for (int j = 0; j < col; j++) {
                left[j] = Math.min(j > 0 ? left[j - 1] : Integer.MAX_VALUE, f[i][j]);
            }
            for (int j = col - 1; j >= 0; j--) {
                right[j] = Math.min(j + 1 < col ? right[j + 1] : Integer.MAX_VALUE, f[i][j]);
            }
        }

        return left[col - 1];
    }

    // 这里换成了min和submin
    public int minCostII2(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int row = costs.length, col = costs[0].length;

        int[][] f = new int[row][col];

        int min = -1, subMin = -1, lastMin, lastSubmin;

        for (int i = 0; i < row; i++) {
            lastMin = min;
            lastSubmin = subMin;
            min = -1;
            subMin = -1;

            for (int j = 0; j < col; j++) {
                if (j == lastMin) {
                    f[i][j] = costs[i][j] + (lastSubmin < 0 ? 0 : f[i - 1][lastSubmin]);
                } else {
                    f[i][j] = costs[i][j] + (lastMin < 0 ? 0 : f[i - 1][lastMin]);
                }

                if (min == -1 || f[i][j] < f[i][min]) {
                    subMin = min;
                    min = j;
                } else if (subMin == -1 || f[i][j] < f[i][subMin]) {
                    subMin = j;
                }
            }
        }

        return f[row - 1][min];
    }

    /**
     * 这个算法是最优的，速度最快，空间最小
     */
    public int minCostII3(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int row = costs.length, col = costs[0].length;

        int prevMin = -1, prevSubmin = -1, prevMinIndex = -1;

        for (int i = 0; i < row; i++) {
            int min = -1, subMin = -1, minIndex = -1;

            for (int j = 0; j < col; j++) {
                int val = 0;

                if (j == prevMinIndex) {
                    val = costs[i][j] + (prevSubmin < 0 ? 0 : prevSubmin);
                } else {
                    val = costs[i][j] + (prevMin < 0 ? 0 : prevMin);
                }

                if (min == -1 || val < min) {
                    subMin = min;
                    min = val;
                    minIndex = j;
                } else if (subMin == -1 || val < subMin) {
                    subMin = val;
                }
            }

            prevMin = min;
            prevSubmin = subMin;
            prevMinIndex = minIndex;
        }

        return prevMin;
    }
}
