package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i > 0 ? nums[i - 1] : 0;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        map.put(0, -1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                int idx = map.get(nums[i] -k);
                if (idx < i) {
                    max = Math.max(max, i - idx);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
