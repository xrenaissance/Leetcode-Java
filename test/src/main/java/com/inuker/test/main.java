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
        int[] range = new SearchForARange().searchRange(new int[] {
                1, 2, 3, 3, 4
        }, 3);
        for (int n : range) {
            System.out.print(n + " ");
        }
    }

    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        long y = Math.abs(x), z = 0;
        for ( ; y > 0; y /= 10) {
            z = z * 10 + y % 10;
        }
        z *= sign;
        if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) {
            throw new IllegalStateException();
        }
        return (int) z;
    }
}
