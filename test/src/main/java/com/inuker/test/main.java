package com.inuker.test;

import com.inuker.solution.SearchForARange;
import com.leetcode.library.ListNode;
import com.leetcode.library.RandomListNode;
import com.leetcode.library.TreeNode;
import com.leetcode.library.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int[] tc = new int[256], sc = new int[256];
        for (char c : t.toCharArray()) {
            tc[c]++;
        }
        int count = 0, min = Integer.MAX_VALUE, start = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (++sc[c] <= tc[c]) {
                ++count;
            }
            if (count == t.length()) {
                for ( ; i < j; i++) {
                    char cc = s.charAt(i);
                    if (sc[cc] <= tc[cc]) {
                        break;
                    }
                    sc[cc]--;
                }
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
