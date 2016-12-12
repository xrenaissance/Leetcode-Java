package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/12/13.
 */

/**
 * https://leetcode.com/articles/3sum-smaller/
 */
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                } else {
                    count += k - j;
                    j++;
                }
            }
        }
        return count;
    }
}
