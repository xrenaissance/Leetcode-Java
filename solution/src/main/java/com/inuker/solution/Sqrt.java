package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class Sqrt {

    public int mySqrt(int x) {
        int left = 1, right = x;

        while (left <= right) {
            int mid = left + ((right - left) >>> 1);

            int y = x / mid;

            if (mid < y) {
                left = mid + 1;
            } else if (mid > y) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}
