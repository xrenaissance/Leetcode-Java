package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/15.
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = Math.max(nums[i], nums[i] + (i > 0 ? f[i - 1] : 0));
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(nums[i], nums[i] + prev);
            max = Math.max(max, prev);
        }
        return max;
    }
}
