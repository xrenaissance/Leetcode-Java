package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int minCost(int[][] costs) {
        int[] f = new int[3];
        int f0 = 0, f1 = 0, f2 = 0;
        for (int i = 0; i < costs.length; i++) {
            f[0] = costs[i][0] + Math.min(f1, f2);
            f[1] = costs[i][1] + Math.min(f0, f2);
            f[2] = costs[i][2] + Math.min(f0, f1);
            f0 = f[0]; f1 = f[1]; f2 = f[2];
        }
        return Math.min(Math.min(f0, f1), f2);
    }
}
