package com.inuker.solution;

/**
 * Created by liwentian on 2016/12/17.
 */

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        int left, right;

        int[] result = new int[] { -1, -1 };

        for (left = 0, right = len - 1; left < right; ) {
            int mid = (left + right) / 2;

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return result;
        } else {
            result[0] = left;
        }

        for (right = len - 1; left < right; ) {
            int mid = (left + right) / 2 + 1;

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        result[1] = right;

        return result;
    }

    /**
    // 测试用例
    // [5,7], [3,5], [5,5], [3,4], [6,7], [3,6], target = 5
    public static int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }

    public static int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1) + 1;

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return nums[right] == target ? right : -1;
    }
     */
}
