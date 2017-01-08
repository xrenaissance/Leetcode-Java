package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            /**
             * 这里别掉了等号
             */
            if (sum >= s) {
                for ( ; j < i && sum - nums[j] >= s; sum -= nums[j], j++);
                min = Math.min(min, i - j + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
