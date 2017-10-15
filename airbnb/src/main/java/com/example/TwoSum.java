package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liwentian on 2017/10/14.
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer k = map.get(target - nums[i]);
            if (k != null && k != i) {
                return new int[] {i, k};
            }
        }
        return null;
    }
}
