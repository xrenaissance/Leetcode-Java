package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

public class Search2DMatrix {

    // 耗时14ms
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, right = row - 1;

        while (left < right) {
            int mid = (left + right) / 2 + 1;

            int n = matrix[mid][0];

            if (target == n) {
                return true;
            } else if (target < n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (target < matrix[right][0]) {
            return false;
        } else if (target == matrix[right][0]) {
            return true;
        }

        return Arrays.binarySearch(matrix[right], 0, col, target) >= 0;
    }
}
