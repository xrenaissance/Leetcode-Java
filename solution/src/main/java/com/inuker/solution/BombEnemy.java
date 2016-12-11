package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;

        int result = 0, rowhits = 0;
        int[] colhits = new int[col];

        for (int i = 0; i < row; i++) {
            // 这个循环里每次都从墙或边界开始，是为了避免重复计算
            for (int j = 0; j < col; j++) {
                /** 如果当前是墙则直接跳过 */
                if (grid[i][j] == 'W') {
                    continue;
                }

                // rowhits表示在当前点横向能杀伤的人数
                // 如果左边靠着墙或边界则统计往右延伸能杀多少敌人
                // 如果不是靠着墙，则不用统计了，直接复用本行之前的结果
                if (j == 0 || grid[i][j - 1] == 'W') {
                    /** 注意这里rowhits要清零 */
                    rowhits = 0;
                    // 往右延伸一直到墙或边界
                    for (int k = j; k < col && grid[i][k] != 'W'; k++) {
                        rowhits += (grid[i][k] == 'E') ? 1 : 0;
                    }
                }

                // colhits表示本行第j列纵向能杀伤的人数
                // 如果上面靠着墙或边界则统计往下延伸能杀伤多少人
                // 如果不是靠着墙则不用统计了，直接复用本列之前的结果
                if (i == 0 || grid[i - 1][j] == 'W') {
                    /** 注意这里colhits[j]要清零 */
                    colhits[j] = 0;
                    // 往下延伸到边界或者墙
                    for (int k = i; k < row && grid[k][j] != 'W'; k++) {
                        colhits[j] += (grid[k][j] == 'E') ? 1 : 0;
                    }
                }

                // 如果当前可以放炸弹，横向和纵向总杀伤人数和
                /** 这里要判断是否可以放炸弹 */
                if (grid[i][j] == '0') {
                    result = Math.max(result, rowhits + colhits[j]);
                }
            }
        }

        return result;
    }
}
