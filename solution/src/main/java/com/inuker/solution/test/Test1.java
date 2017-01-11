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

    /**
     * 这题容易错的有两点：
     * 1. 不能用mid * mid，可能会溢出，需要用x / mid
     * 2. 临界点的情况，即mid < m的情况，此时结果可能等于mid，也可能更大，l = mid是没问题的，只是我们要考虑只剩两个数的
     * 情形，因为会死循环。假设最后两个数是a和b，假设mid为a时mid<m，则l=mid+1，这样做是为了验证b，如果b的时候mid大于m了，
     * 则r=mid-1会返回a。如果b的时候mid小于m，则l=mid+1会超出范围，最后还是返回l-1
     */
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int m = x / mid;

            if (mid == m) {
                return mid;
            } else if (mid > m) {
                r = mid - 1;
            } else if (mid < m) {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
