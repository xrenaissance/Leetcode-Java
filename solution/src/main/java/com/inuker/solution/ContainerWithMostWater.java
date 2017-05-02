package com.inuker.solution;

/**
 * Created by dingjikerbo on 17/5/2.
 */

/**
 * 本体可用暴力法，但显然会超时
 * 一种O(n)的方法是对于区间[left, right]，假如height[left] < height[right]，则我们可以认定[left, right - 1]，[left, right - 2] ...
 * 都不会比[left, right]装的水更多。原因是假如height[right - 1]比height[left]高，则水平面高度不变，但
 * 宽度减小了。假如height[right - 1]比height[left]矮，则一样装的水会更少。所以对于一个区间，我们总是从矮的一方往前递进。
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;

        for (int left = 0, right = height.length - 1; left < right; ) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
