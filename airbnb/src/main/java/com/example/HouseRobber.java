package com.example;

/**
 * Created by liwentian on 2017/10/15.
 */

public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + i > 1 ? dp[i - 2] : 0, dp[i - 1]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        int prev = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = cur;
            cur = Math.max(prev + nums[i], cur);
            prev = temp;
        }
        return cur;
    }
}
