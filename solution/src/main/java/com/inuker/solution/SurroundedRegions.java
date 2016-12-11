package com.inuker.solution;

import java.util.Arrays;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

public class SurroundedRegions {

    private int[] mRoot; // union find set
    private boolean[] mHasEdge; // whether an union has an 'O' which is on the edge of the matrix

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        // init, every char itself is an union
        int row = board.length, col = board[0].length;
        mRoot = new int[row * col];
        mHasEdge = new boolean[mRoot.length];
        for (int i = 0; i < mRoot.length; i++) {
            mRoot[i] = i;
        }
        for (int i = 0; i < mHasEdge.length; i++) {
            int x = i / col, y = i % col;
            mHasEdge[i] = (board[x][y] == 'O' && (x == 0 || x == row - 1 || y == 0 || y == col - 1));
        }

        // iterate the matrix, for each char, union it + its upper char + its right char if they equals to each other
        for (int i = 0; i < mRoot.length; i++) {
            int x = i / col, y = i % col, up = x - 1, right = y + 1;
            if (up >= 0 && board[x][y] == board[up][y]) union(i, i - col);
            if (right < col && board[x][y] == board[x][right]) union(i, i + 1);
        }

        // for each char in the matrix, if it is an 'O' and its union doesn't has an 'edge O', the whole union should be setted as 'X'
        for (int i = 0; i < mRoot.length; i++) {
            int x = i / col, y = i % col;
            if (board[x][y] == 'O' && !mHasEdge[find(i)])
                board[x][y] = 'X';
        }
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // if there is an union has an 'edge O',the union after merge should be marked too
        mRoot[rootX] = rootY;
        mHasEdge[rootY] = mHasEdge[rootX] || mHasEdge[rootY];
    }

    private int find(int root) {
        if (mRoot[root] == root) {
            return root;
        }
        // 在找的过程中直接联通到根节点了，这样的好处是加速未来的查找
        mRoot[root] = find(mRoot[root]);
        return mRoot[root];
    }
}
