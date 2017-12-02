package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.Interval;
import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
    }

    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, killedEnemies(grid, i, j));
                }
            }
        }
        return max;
    }

    private int killedEnemies(char[][] grid, int i, int j) {
        int count = 0;
        for (int k = j - 1; k >= 0 && grid[i][k] != 'W'; k--) {
            if (grid[i][k] == 'E') {
                count++;
            }
        }
        for (int k = j + 1; k < grid[0].length && grid[i][k] != 'W'; k++) {
            if (grid[i][k] == 'E') {
                count++;
            }
        }
        for (int k = i - 1; k >= 0 && grid[k][j] != 'W'; k--) {
            if (grid[k][j] == 'E') {
                count++;
            }
        }
        for (int k = i + 1; k < grid.length && grid[k][j] != 'W'; k++) {
            if (grid[k][j] == 'E') {
                count++;
            }
        }
        return count;
    }
}
