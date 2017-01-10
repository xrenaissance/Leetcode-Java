package com.inuker.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/11/22.
 */

public class SortColors {

    // 时间复杂度O(n)，扫一遍
    public void sortColors3(int[] nums) {
        int zero = -1, two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i++);
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    /**
     * 如果要扩展到k个颜色，如果颜色为0~k
     * 时间复杂度O(n)，空间复杂度O(l)
     */
    public void sortKColors(int[] colors, int k) {
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] >= 0) {
                int color = colors[i];
                if (colors[color] >= 0) {
                    colors[i] = colors[color];
                    colors[color] = -2;
                } else {
                    colors[color]--;
                    colors[i] = -1;
                }
            }
        }
        for (int i = colors.length - 1; i >= 0; ) {
            int color = --k, count = -(colors[color] + 1);
            for (int j = 0; j < count; j++) {
                colors[i--] = color;
            }
        }
    }

    /**
     * http://www.lintcode.com/zh-cn/problem/sort-colors-ii/
     */
    // 如果颜色从1~k，lint
    public void sortColors2(int[] colors, int k) {
        // write your code here
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] > 0) {
                int color = colors[i];
                if (colors[color - 1] > 0) {
                    colors[i] = colors[color - 1];
                    colors[color - 1] = -1;
                } else {
                    colors[color - 1]--;
                    colors[i] = 0;
                }
            }
        }
        int color = k - 1;
        for (int i = colors.length - 1; i >= 0; ) {
            for (int j = 0; j < -colors[color]; j++) {
                colors[i--] = color + 1;
            }
            color--;
        }
    }
}
