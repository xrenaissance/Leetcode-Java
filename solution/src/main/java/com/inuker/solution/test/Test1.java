package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.PathSum;
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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<int[]>();
        Queue<int[]> next = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int distance = 0;
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            x = pos[0]; y = pos[1];

            for (int i = 0; i < dx.length; i++) {
                int x0 = x + dx[i], y0 = y + dy[i];
                if (x0 >= 0 && x0 < rooms.length && y0 >= 0 && y0 < rooms[0].length && rooms[x0][y0] > 0 && !visited[x0][y0]) {
                    visited[x0][y0] = true;
                    rooms[x0][y0] = Math.min(rooms[x0][y0], distance + 1);
                    next.add(new int[] {x0, y0});
                }
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                distance++;
            }
        }
    }

     boolean knows(int a, int b) {
        return false;
     }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

     int read4(char[] buf) {
         return 0;
     }

    private static final String[] LESS20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] LESS100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] THOUSAND = {
            "", "Thousand", "Million", "Billion"
    };

}
