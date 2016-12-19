package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/12/17.
 */

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        for (int i = 1; i < k; i++) {
            nextPermutation(nums);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void nextPermutation(int[] nums) {

    }
}
