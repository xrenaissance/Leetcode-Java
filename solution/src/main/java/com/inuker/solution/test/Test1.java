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

    public int countComponents(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = i;
            count++;
        }
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            if (x != y) {
                // union
                nums[x] = y;
                count--;
            }
        }

        return count;
    }

    int find(int nums[], int i) {
        for (; nums[i] != i; i = nums[i]);
        return i;
    }

}
