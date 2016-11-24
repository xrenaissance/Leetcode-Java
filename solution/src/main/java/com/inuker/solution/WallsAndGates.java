package com.inuker.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 16/11/25.
 */

public class WallsAndGates {

    // 耗时7ms
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }

        // 这个条件非常重要
        // 如果rooms[i][j]=0,dis=0，则这里可以继续走下去
        // 如果rooms[i][j]=0,dis!=0，则这里直接跳过，表示遇到另一个0了，那个门的情况我们不处理
        // 如果room[i][j]!=0,dis!=0,但是rooms[i][j]<dis，有两种情况，
        //      1. 一种是在当前dfs中该节点被访问过了，所以值会比dis小，这种情况下就别重复访问了
        //      2. 另一种是当前dfs没访问过，但是在另一个dfs中访问过了，该节点离另一个门比较近，所以这个节点会绕过，虽然这个节点
        // 的邻居节点本次没有访问，但是仍然会通过其他的路径访问到的，所以这里直接return没有影响。
        if (rooms[i][j] < dis) {
            return;
        }

        rooms[i][j] = dis;

        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
    }

    // 耗时19ms
    public void wallsAndGates2(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
