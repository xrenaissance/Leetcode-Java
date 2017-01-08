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
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i > 0 && dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
