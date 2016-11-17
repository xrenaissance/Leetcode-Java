package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/17.
 */

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        return null;
    }
}
