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

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        if (k == 0) {
            return result;
        }
        dfs(k, n, 1, result, new LinkedList<>());
        return result;
    }

    private void dfs(int k, int n, int start, List<List<Integer>> result, List<Integer> list) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            if (k == 0) {
                result.add(new LinkedList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs(k - 1, n - i, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}
