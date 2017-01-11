package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;
import com.inuker.solution.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
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

    private final String[] ARR = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if (digits.length() == 0) {
            return queue;
        }

        Queue<String> next = new LinkedList<>();
        queue.add("");

        int start = 0;
        while (!queue.isEmpty() && start < digits.length()) {
            String s = queue.poll();
            int n = digits.charAt(start) - '0';
            for (char c : ARR[n].toCharArray()) {
                next.add(s + c);
            }
            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                start++;
            }
        }
        return queue;
    }



//    public List<String> letterCombinations2(String digits) {
//        List<String> list = new LinkedList<>();
//        if (digits.length() == 0) {
//            return list;
//        }
//
//        String s = "";
//        for (int i = 0; i <= digits.length(); i++) {
//            if (i == digits.length()) {
//                list.add(s);
//            }
//
//            int n = digits.charAt(start) - '0';
//            for (char c : ARR[n].toCharArray()) {
//                dfs(digits, list, start + 1, s + c);
//            }
//        }
//
//        return list;
//    }
//
//    private void dfs(String digits, List<String> list, int start, String s) {
//        if (start == digits.length()) {
//            list.add(s);
//            return;
//        }
//
//        int n = digits.charAt(start) - '0';
//        for (char c : ARR[n].toCharArray()) {
//            dfs(digits, list, start + 1, s + c);
//        }
//    }

}
