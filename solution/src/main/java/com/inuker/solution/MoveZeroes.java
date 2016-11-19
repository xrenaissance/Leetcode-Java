package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0, left = 0; left < nums.length; ) {
            if (i < nums.length) {
                if (nums[i] != 0) {
                    nums[left++] = nums[i];
                }
                i++;
            } else {
                nums[left++] = 0;
            }
        }
    }
}
