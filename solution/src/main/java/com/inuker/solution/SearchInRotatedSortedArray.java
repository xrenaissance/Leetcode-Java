package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 注意这里的等号
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);

            if (target == nums[mid]) {
                return mid;
            }

            // 注意这里的等号
            // 先确定单调区间，然后判断target是不是在单调区间内，如果不在就在另一半区间
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
