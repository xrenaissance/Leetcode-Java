package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/17.
 */

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        for ( ; left < right; ) {
            int mid = left + ((right - left) >> 1);

            if (nums[right] > nums[left]) {
                return nums[left];
            }

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left++;
            }
        }

        return nums[left];
    }
}
