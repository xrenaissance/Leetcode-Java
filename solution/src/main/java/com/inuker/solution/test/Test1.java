package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        dfs(num, result, 0, "", target, 0, 0);
        return result;
    }

    private void dfs(String num, List<String> result, int start, String s, int target, long val, long last) {
        if (start == num.length()) {
            if (val == target) {
                result.add(s);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && i != start) {
                break;
            }

            long n = Long.valueOf(num.substring(start, i + 1));

            if (start == 0) {
                dfs(num, result, i + 1, n + "", target, n, n);
            } else {
                dfs(num, result, i + 1, s + "+" + n, target, val + n, n);
                dfs(num, result, i + 1, s + "-" + n, target, val - n, -n);
                dfs(num, result, i + 1, s + "*" + n, target, val - last + last * n, last * n);
            }
        }
    }
}
