package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; j++) {
            if (j < nums.length) {
                if (nums[j] != 0) {
                    nums[i++] = nums[j];
                }
            } else {
                nums[i++] = 0;
            }
        }
    }
}
