package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/16.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * TestCases
 * ["11110","11010","11000","00000"]
 * ["11000","11000","00100","00011"]
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // 耗时3ms
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    // 耗时12ms
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            i = position[0];
            j = position[1];

            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                continue;
            }

            if (grid[i][j] != '1') {
                continue;
            } else {
                grid[i][j] = '0';
            }

            queue.add(new int[] {i + 1, j});
            queue.add(new int[] {i - 1, j});
            queue.add(new int[] {i, j + 1});
            queue.add(new int[] {i, j - 1});
        }

    }
}
