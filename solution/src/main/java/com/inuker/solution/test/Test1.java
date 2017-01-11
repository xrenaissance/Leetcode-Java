package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;
import com.inuker.solution.TrieNode;
import com.inuker.solution.UndirectedGraphNode;

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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {i, j});

        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, - 1, 1};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            for (int k = 0; k < dx.length; k++) {
                int x0 = x + dx[k], y0 = y + dy[k];
                if (x0 >= 0 && x0 < grid.length && y0 >= 0 && y0 < grid[0].length) {
                    grid[x0][y0] = 'x';
                    queue.add(new int[] {x0, y0});
                }
            }
        }
    }

}
