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

//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] f = new int[nums.length];
//        Arrays.fill(f, 1);
//        int max = 1;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//            max = Math.max(f[i], max);
//        }
//        return max;
//    }

    public int lengthOfLIS(int[] nums) {
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            int k = Arrays.binarySearch(nums, 0, len, nums[i]);
            if (k < 0) {
                k = -(k + 1);
                if (k == len) {
                    len++;
                }
                nums[k] = nums[i];
            }
        }
        return len;
    }
}
