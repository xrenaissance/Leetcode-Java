package com.inuker.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dingjikerbo on 2016/11/16.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                if (index != i) {
                    return new int[] { i, index };
                }
            }
        }

        return null;
    }
}
