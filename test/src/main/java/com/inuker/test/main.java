package com.inuker.test;

import com.leetcode.library.ListNode;
import com.leetcode.library.RandomListNode;
import com.leetcode.library.TreeNode;
import com.leetcode.library.UndirectedGraphNode;

import java.util.ArrayList;
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
        String[][] strs = new String[][]{
//                {"MUC", "LHR"},
//                {"JFK", "MUC"},
//                {"SFO", "SJC"},
//                {"LHR", "SFO"}
                {"JFK", "SFO"},
                {"JFK", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "JFK"},
                {"ATL", "SFO"},
        };
        List<String> lists = new Test2().findItinerary(strs);
//        List<String> lists = new Solution().findItinerary(strs);
//        for (String s : lists) {
//            System.out.print(s + " ");
//        }

        for (String s : lists) {
            System.out.print(s + " ");
        }
    }
}
