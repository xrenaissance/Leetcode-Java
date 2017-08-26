package com.leetcode.topics.combination;

import java.util.Arrays;

/**
 * Created by liwentian on 17/8/15.
 */

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        Arrays.sort(nums);

        dp[0] = 1;

        for (int i = 1; i <= target; i++){
            for (int n : nums) {
                if (n > i) {
                    break;
                } else {
                    dp[i] += dp[i - n];
                }
            }
        }

        return dp[target];
    }
}
