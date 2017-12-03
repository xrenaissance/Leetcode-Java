package com.inuker.test;

import com.leetcode.library.TreeNode;

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
import java.util.Set;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        List<String> list = summaryRanges(new int[] {
                0, 1, 2, 4, 5, 7
        });
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int start = nums[0], to = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == to + 1) {
                to++;
            } else {
                list.add(getRange(start, to));
                start = to = nums[i];
            }
        }
        list.add(getRange(start, to));
        return list;
    }

    private static String getRange(int start, int to) {
        return to > start ? start + "->" + to : String.valueOf(to);
    }
}
