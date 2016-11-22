package com.inuker.solution;

import java.util.Random;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class RandomPickIndex {

    private Random mRandom;
    private int[] mNums;

    public RandomPickIndex(int[] nums) {
        mRandom = new Random();
        mNums = nums;
    }

    public int pick(int target) {
        int count = 0;

        int result = -1;

        for (int i = 0; i < mNums.length; i++) {
            if (mNums[i] == target && mRandom.nextInt(++count) == 0) {
                result = i;
            }
        }

        return result;
    }
}
