package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 16/12/10.
 */

/**
 * https://leetcode.com/articles/wiggle-sort/
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i + 1 < nums.length; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    // 复杂度O(n)
    public void wiggleSort2(int[] nums) {
        boolean asc = true;
        for (int i = 0; i + 1 < nums.length; i++, asc = !asc) {
            if (asc) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
