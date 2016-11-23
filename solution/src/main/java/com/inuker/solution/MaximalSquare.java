package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/23.
 */

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[][] f = new int[row][col];
        for (int i = 0; i < row; i++) {
            f[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(f[i][0], max);
        }
        for (int i = 0; i < col; i++) {
            f[0][i] = matrix[0][i] == '0' ? 0 : 1;
            max = Math.max(f[0][i], max);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (f[i][j] == '0') {
                    f[i][j] = 0;
                } else {
                    int size = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(f[i - 1][j - 1], size) + 1;
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max * max;
    }
}
