package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public class MaximumSizeSubarraySumEqualsK {

    // 耗时218ms，时间复杂度O(n^2)
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i, sum = 0; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, i - j + 1);
                }
            }
        }
        return maxLen;
    }

    // 耗时29ms，时间复杂度O(n)
    public int maxSubArrayLen2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            nums[i] += i > 0 ? nums[i - 1] : 0;

            // 这里要注意判重，map中保存最靠左的，这样子序列能更长
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                maxLen = i + 1;
            } else if (map.containsKey(nums[i] - k)) {
                int index = map.get(nums[i] - k);
                if (index < i) {
                    maxLen = Math.max(maxLen, i - index);
                }
            }
        }
        return maxLen;
    }
}
