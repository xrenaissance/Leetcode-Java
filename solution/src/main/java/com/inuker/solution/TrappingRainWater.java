package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

/**
 * 核心思路就是对于每根柱子，找到其左边最高的柱子和右边最高的柱子，构成一个桶，形成一个水平面，然后对该柱子形成的高度差就是能装的水
 */
public class TrappingRainWater {

    // 耗时166ms
    public int trap(int[] height) {
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            int left = height[i];

            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }

            int right = height[i];

            for (int j = i + 1; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }

            int level = Math.min(left, right);
            water += (level > height[i] ? level - height[i] : 0);
        }

        return water;
    }

    // 耗时24ms
    public int trap2(int[] height) {
        int len = height.length;

        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }

        int water = 0;

        for (int i = 1; i < len - 1; i++) {
            int level = Math.min(left[i], right[i]);
            if (level > height[i]) {
                water += level - height[i];
            }
        }

        return water;
    }
}
