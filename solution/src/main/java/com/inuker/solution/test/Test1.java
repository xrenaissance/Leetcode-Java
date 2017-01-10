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

    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int k = costs[0].length;
        int min = 0, minIdx = -1, submin = 0;
        for (int i = 0; i < costs.length; i++) {
            int min0 = Integer.MAX_VALUE, minIdx0 = -1, submin0 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j != minIdx ? min : submin);
                if (cost < min0) {
                    submin0 = min0;
                    min0 = cost;
                    minIdx0 = j;
                } else if (cost < submin0) {
                    submin0 = cost;
                }
            }
            min = min0; minIdx = minIdx0; submin = submin0;
        }
        return min;
    }
}
