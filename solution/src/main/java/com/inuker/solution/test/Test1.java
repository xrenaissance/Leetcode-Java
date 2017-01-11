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

    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int k = result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = k % 10;
                result[i + j] += k / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
