package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int min = 1, max = nums.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;

            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
