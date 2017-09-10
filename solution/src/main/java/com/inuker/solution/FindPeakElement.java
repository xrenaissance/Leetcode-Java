package com.inuker.solution;

/**
 * Created by liwentian on 2017/9/10.
 */

/**
 * https://leetcode.com/articles/find-peak-element/
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return Helper(nums, 0, nums.length - 1);
    }

    private int Helper(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        } else {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) {
                return Helper(nums, low, mid1);
            } else {
                return Helper(nums, mid2, high);
            }
        }
    }
}

