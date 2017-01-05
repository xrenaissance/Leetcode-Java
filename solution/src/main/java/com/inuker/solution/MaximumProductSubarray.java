package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/1/5.
 */

public class MaximumProductSubarray {

    /**
     * 这题很容易错的地方在于要同时记住最大值和最小值，因为可能有负数，
     * 最小的负数乘以负数可能会变成最大的正直
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max0 = 1, min0 = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int n1 = Math.max(min0 * nums[i], Math.max(nums[i], max0 * nums[i]));
            int n2 = Math.min(max0 * nums[i], Math.min(nums[i], min0 * nums[i]));
            max0 = n1;
            min0 = n2;
            max = Math.max(max, max0);
        }
        return max;
    }
}
