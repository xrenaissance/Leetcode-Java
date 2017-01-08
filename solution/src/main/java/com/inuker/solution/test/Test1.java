package com.inuker.solution.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // 别忘了加限制条件
            if (i >= k) {
                int n = nums[i - k];
                int nn = map.getOrDefault(n, 0);
                if (nn == 1) {
                    map.remove(n);
                } else {
                    map.put(n, nn - 1);
                }
            }

            // 别忘了加限制条件
            if (i >= k - 1) {
                result[i - k + 1] = map.firstKey();
            }
        }

        return result;
    }
}
