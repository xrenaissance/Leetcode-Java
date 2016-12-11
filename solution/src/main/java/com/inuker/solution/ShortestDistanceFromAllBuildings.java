package com.inuker.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

public class ShortestDistanceFromAllBuildings {

    /**
     * 这道题思路是以所有建筑为根开始BFS，对所有覆盖到的点计算距离，
     * 每个空白点可能会同时被好几个建筑覆盖，所以其距离是叠加的，表示该点到那几个联通建筑的距离之和
     * 最后遍历所有空白点，求距离和最小的，同时能联通所有建筑的
     */
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        Queue<int[]> temp = new LinkedList<int[]>();
        int row = grid.length, col = grid[0].length;

        int[][] distance = new int[row][col];

        // 因为要保证能通往所有建筑，所以这里记录每个点被建筑遍历到的次数
        int[][] reach = new int[row][col];

        // 建筑数
        int buildings = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }

                buildings++;
                queue.clear();
                queue.add(new int[] {i, j});

                boolean[][] visited = new boolean[row][col];
                int level = 0;

                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    int x = pos[0], y = pos[1];

                    // 被建筑遍历到了
                    distance[x][y] += level;
                    reach[x][y]++;

                    if (x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] == 0) {
                        visited[x - 1][y] = true;
                        temp.add(new int[] {x - 1, y});
                    }

                    if (x + 1 < row && !visited[x + 1][y] && grid[x + 1][y] == 0) {
                        visited[x + 1][y] = true;
                        temp.add(new int[] {x + 1, y});
                    }

                    if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] == 0) {
                        visited[x][y - 1] = true;
                        temp.add(new int[] {x, y - 1});
                    }

                    if (y + 1 < col && !visited[x][y + 1] && grid[x][y + 1] == 0) {
                        visited[x][y + 1] = true;
                        temp.add(new int[] {x, y + 1});
                    }

                    if (queue.isEmpty()) {
                        queue.addAll(temp);
                        temp.clear();
                        level++;
                    }
                }
            }
        }

        int shortest = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) {
                    shortest = shortest == -1 ? distance[i][j] : Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest;
    }
}
