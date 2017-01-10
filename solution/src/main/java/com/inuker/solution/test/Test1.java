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

    int[] root;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] root = new int[m * n];
        for (int[] position : positions) {
            int x = position[0] * n + position[1];

        }
    }

    private void union(int x, int y) {
        int x0 = find(x);
        int y0 = find(y);
        if (x0 != y0) {
            root[x0] = y0;
        }
    }

    private int find(int x) {
        while (root[x] != -1) {
            x = root[x];
        }
        return x;
    }
}
