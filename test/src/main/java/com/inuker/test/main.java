package com.inuker.test;

import com.inuker.solution.NextPermutation;
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
        int[] arr = new int[]{
                2, 2, 0, 4, 3, 1
        };
        new NextPermutation().nextPermutation(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int x = mid / col, y = mid % col;
            if (target == matrix[x][y]) {
                return true;
            } else if (target > matrix[x][y]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
