package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by liwentian on 2016/11/16.
 */

public class ProductOfArrayExceptSelf {

    // 耗时3ms
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int left = 1, right = 1;

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
