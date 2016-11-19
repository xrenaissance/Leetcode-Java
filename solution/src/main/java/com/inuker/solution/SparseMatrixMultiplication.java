package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int M = A.length, T = B.length, N = B[0].length;

        int[][] C = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < T; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < N; k++) {
                        if (B[j][k] != 0) {
                            C[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }

        return C;
    }
}
