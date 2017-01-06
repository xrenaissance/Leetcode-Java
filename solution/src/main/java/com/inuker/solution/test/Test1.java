package com.inuker.solution.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {



    public class Solution {

        private int[] mNums;
        private Random mRandom;

        public Solution(int[] nums) {
            mNums = nums;
            mRandom = new Random();
        }

        public int pick(int target) {
            int count = 0, result = -1;
            for (int i = 0; i < mNums.length; i++) {
                if (mNums[i] == target && mRandom.nextInt(++count) == 0) {
                    result = i;
                }
            }
            return result;
        }
    }

    boolean knows(int a, int b) {
        return false;
    }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    int read4(char[] buf) {
        return 0;
    }

    private static final String[] LESS20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] LESS100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] THOUSAND = {
            "", "Thousand", "Million", "Billion"
    };

}
