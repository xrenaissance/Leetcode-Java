package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 2016/11/22.
 */

public class SortColors {

    // 时间复杂度O(nlgn)
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // 时间复杂度O(n)，不过要扫两遍
    public void sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int n : nums) {
            count[n]++;
        }

        for (int i = 0, k = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }

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
}
