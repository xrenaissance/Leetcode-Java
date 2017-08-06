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

    /**
     * 别掉了grid[i][j] != '1'
     */
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

        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, - 1, 1};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            for (int k = 0; k < dx.length; k++) {
                int x0 = x + dx[k], y0 = y + dy[k];
                if (x0 >= 0 && x0 < grid.length && y0 >= 0 && y0 < grid[0].length && grid[x0][y0] == '1') {
                    grid[x0][y0] = 'x';
                    queue.add(new int[] {x0, y0});
                }
            }
        }
    }
}
