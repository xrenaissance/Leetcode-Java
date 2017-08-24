package com.inuker.solution.topics.BIT;

/**
 * Created by dingjikerbo on 16/11/27.
 */

/**
 * 这道题也可以用2D BIT
 * 参考https://discuss.leetcode.com/topic/30343/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
 */
public class NumMatrixII {

    private int[][] mMatrix;
    private int mRow, mCol;

    public NumMatrixII(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        mRow = matrix.length;
        mCol = matrix[0].length;

        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mCol; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        mMatrix = matrix;
    }

    public void update(int row, int col, int val) {
        int orig = mMatrix[row][col] - (col > 0 ? mMatrix[row][col - 1] : 0);
        int delta = val - orig;
        for (int i = col; i < mCol; i++) {
            mMatrix[row][i] += delta;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += mMatrix[i][col2] - (col1 > 0 ? mMatrix[i][col1 - 1] : 0);
        }
        return sum;
    }
}
