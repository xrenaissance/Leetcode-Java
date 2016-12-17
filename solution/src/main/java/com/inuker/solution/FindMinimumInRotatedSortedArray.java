package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/17.
 */

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        for (int left = 0, right = nums.length - 1; left >= 0 && left <= right; ) {
            if (nums[right] > nums[left]) {
                return nums[left];
            }
            int mid = left + ((right - left) >> 1);

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                return Math.min(nums[left], nums[right]);
            }
        }
        return 0;
    }
}
