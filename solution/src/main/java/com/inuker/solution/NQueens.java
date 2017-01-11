package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 17/1/12.
 */

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int[] f = new int[n];
        dfs(f, result, 0);
        return result;
    }

    private void dfs(int[] f, List<List<String>> result, int row) {
        if (row == f.length) {
            List<String> list = new LinkedList<>();
            char[] c = new char[f.length];
            for (int i = 0; i < f.length; i++) {
                Arrays.fill(c, '.');
                for (int j = 0; j < f.length; j++) {
                    if (j == f[i]) {
                        c[j] = 'Q';
                        break;
                    }
                }
                list.add(String.valueOf(c));
            }
            result.add(list);
        }
        for (int j = 0; j < f.length; j++) {
            if (isValid(f, row, j)) {
                f[row] = j;
                dfs(f, result, row + 1);
            }
        }
    }

    private boolean isValid(int[] f, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (f[i] == col) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(f[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
