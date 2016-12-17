package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/17.
 */

/**
 * https://leetcode.com/articles/next-permutation/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;

        for ( ; i >= 0; i--) {
            if (i > 0 && nums[i - 1] < nums[i]) {
                break;
            }
        }

        if (i < 0) {
            revert(nums, 0, nums.length - 1);
            return;
        }

        int index = searchSwapPoint(nums, i, nums.length - 1, nums[i - 1]);

        swap(nums, i - 1, index);
        revert(nums, i, nums.length - 1);
    }

    private int searchSwapPoint(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (left == mid) {
                if (target >= nums[right]) {
                    return right - 1;
                } else {
                    return right;
                }
            }

            if (target > nums[mid]) {
                right = mid - 1;
            } else if (target < nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        throw new IllegalStateException("");
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void revert(int[] nums, int start, int end) {
        for ( ; start < end; start++, end--) {
            swap(nums, start, end);
        }
    }
}
