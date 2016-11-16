package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */
public class RotateImage {

    // 耗时2ms
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i0, int j0, int i1, int j1) {
        int temp = matrix[i0][j0];
        matrix[i0][j0] = matrix[i1][j1];
        matrix[i1][j1] = temp;
    }
}
