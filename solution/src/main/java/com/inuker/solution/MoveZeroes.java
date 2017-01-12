package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

/**
 * https://leetcode.com/articles/move-zeroes/
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

    /**
     * 要求操作次数最少，且不要求保持顺序，无需理会超出的部分，所以这里不用swap，另外当i==j时就不要多余地操作一次了
     * 最后返回有效部分的长度
     */
    public int moveZeroes2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] == 0) {
                j--;
            } else {
                if (i != j) {
                    nums[i] = nums[j];
                }
                i++;
                j--;
            }
        }
        return i;
    }
}
