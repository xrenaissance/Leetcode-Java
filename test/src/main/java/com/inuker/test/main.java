package com.inuker.test;

import com.inuker.solution.NestedInteger;
import com.leetcode.library.Interval;
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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class main {

    public static void main(String[] args) {
        Test test = new Test();
        test.call("hello");
        test.call("how");
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longest = 0;
        int[] dp = new int[256];
        for (int i = 0, j = 0, n = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (dp[c]++ == 0) {
                for (++n; i <= j && n > k; i++) {
                    if (--dp[s.charAt(i)] == 0) {
                        n--;
                    }
                }
            }
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }
}
