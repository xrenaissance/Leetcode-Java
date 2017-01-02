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

    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int min = 0, minIndex = -1, subMin = 0;

        for (int i = 0; i < n; i++) {
            int curMin = Integer.MAX_VALUE, curMinIdx = -1, curSub = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int value = (j != minIndex ? min : subMin) + costs[i][j];
                if (value < curMin) {
                    curSub = curMin;
                    curMin = value;
                    curMinIdx = j;
                } else if (value < curSub) {
                    curSub = value;
                }
            }
            min = curMin;
            minIndex = curMinIdx;
            subMin = curSub;
        }
        return min;
    }
}
