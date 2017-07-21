package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/28.
 */

/**
 * 动态规划，依次建立1,2,3,...颗节点能有多少种树构造的dp
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
