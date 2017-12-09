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
        System.out.println(getTag("abc"));
        System.out.println(getTag("bcd"));
        System.out.println(getTag("cde"));
    }

    static String getTag(String s) {
        int diff = (int) s.charAt(0) - (int) 'a';

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append((c + 26 - diff) % 26);

        return sb.toString();
    }
}
