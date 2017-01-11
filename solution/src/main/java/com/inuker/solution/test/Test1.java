package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;
import com.inuker.solution.TrieNode;

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
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] f = new int[row][col];
        int max = 0;
        for (int i = 0; i < col; i++) {
            f[0][i] = matrix[0][i] == '0' ? 0 : 1;
            max = Math.max(max, f[0][i]);
        }
        for (int i = 0; i < row; i++) {
            f[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(max, f[i][0]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0') {
                    f[i][j] = 0;
                } else {
                    int min = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(min, f[i - 1][j - 1]) + 1;
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max * max;
    }
}
