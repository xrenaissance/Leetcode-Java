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
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
//                    bfs(grid, i, j);
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    // 耗时3ms
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'x';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    // 耗时6ms
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            if (x > 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = 'x';
                queue.add(new int[] {x - 1, y});
            }

            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                grid[x + 1][y] = 'x';
                queue.add(new int[] {x + 1, y});
            }

            if (y > 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = 'x';
                queue.add(new int[] {x, y - 1});
            }

            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                grid[x][y + 1] = 'x';
                queue.add(new int[] {x, y + 1});
            }
        }
    }
}
