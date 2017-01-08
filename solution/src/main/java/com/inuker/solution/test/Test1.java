package com.inuker.solution.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = min = nums[i];
            } else {
                int prevMax = max, prevMin = min;
                max = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * prevMin));
                min = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * prevMin));
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
