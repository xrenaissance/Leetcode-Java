package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeLinkNode;
import com.inuker.solution.TreeNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int[] f0 = new int[n];
        int[] f1 = new int[n];
        int[] f2 = new int[n];
        for (int i = 0; i < costs.length; i++) {
            f0[i] = (i > 0 ? Math.min(f1[i - 1], f2[i - 1]) : 0) + costs[i][0];
            f1[i] = (i > 0 ? Math.min(f0[i - 1], f2[i - 1]) : 0) + costs[i][1];
            f2[i] = (i > 0 ? Math.min(f0[i - 1], f1[i - 1]) : 0) + costs[i][2];
        }
        int min = Math.min(f0[n - 1], f1[n - 1]);
        return Math.min(min, f2[n - 1]);
    }
}
