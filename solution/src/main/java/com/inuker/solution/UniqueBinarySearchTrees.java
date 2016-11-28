package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/28.
 */

public class UniqueBinarySearchTrees {
    /**
     * 起初超时了，后来加上map发现一点作用也没有，因为递归时根本没机会用到map
    public int numTrees(int n) {
        return numTrees(n, new HashMap<Integer, Integer>());
    }

    private int numTrees(int n, HashMap<Integer, Integer> map) {
        if (n <= 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        map.put(n, sum);
        return sum;
    }*/

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
