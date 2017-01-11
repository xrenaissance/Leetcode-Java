package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
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

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        if (start == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }

        list.add(nums[start]);
        dfs(nums, start + 1, result, list);
        list.remove(list.size() - 1);

        int i = start + 1;
        for ( ; i < nums.length && nums[i] == nums[i - 1]; i++);
        dfs(nums, i, result, list);
    }
}
