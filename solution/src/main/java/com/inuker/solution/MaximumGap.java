package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/12/8.
 */

public class MaximumGap {

    // 耗时5ms，木桶原理
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if (min == max) {
            return 0;
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] mins = new int[nums.length - 1], maxs = new int[nums.length - 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        for (int n : nums) {
            if (n == min || n == max) {
                continue;
            }
            int index = (n - min) / gap;
            mins[index] = Math.min(mins[index], n);
            maxs[index] = Math.max(maxs[index], n);
        }
        int last = min, maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (mins[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, mins[i] - last);
            last = maxs[i];
        }
        maxGap = Math.max(maxGap, max - last);
        return maxGap;
    }
}
