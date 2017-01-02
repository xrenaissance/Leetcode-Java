package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/12/18.
 */

public class PaintHouseII {

    /**
     * 思路很简单，只要记录上一个house为止的最小cost及index以及次小cost即可
     * 遍历当前house的各种颜色，如果当前颜色和上个house最小cost的颜色不同，则上个house可以取最小cost，否则取次小cost
     */
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int min = 0, minIndex = -1, subMin = 0;

        for (int i = 0; i < n; i++) {
            int curMin = Integer.MAX_VALUE, curMinIdx = -1, curSub = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int value = (j != minIndex ? min : subMin) + costs[i][j];
                if (value < curMin) {
                    curSub = curMin;
                    curMin = value;
                    curMinIdx = j;
                } else if (value < curSub) {
                    curSub = value;
                }
            }
            min = curMin;
            minIndex = curMinIdx;
            subMin = curSub;
        }
        return min;
    }
}
