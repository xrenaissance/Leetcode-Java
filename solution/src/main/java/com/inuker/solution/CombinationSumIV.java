package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 这里排序便于之后break
        Arrays.sort(nums);
        // 这里0为什么是1呢，我开始也不解，其实就是说如果组合中带的刚好是当前数，那么组合数只有1种。比如target为3的时候，遍历到了nums中的3，那么只有1种可能。target为2的时候，遍历到了nums中的2，也只有一种可能
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
