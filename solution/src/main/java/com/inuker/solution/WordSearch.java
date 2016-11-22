package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class WordSearch {

    // 耗时9ms
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int start) {
        if (start >= word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        char c = board[x][y];

        if (c != word.charAt(start)) {
            return false;
        }

        // 这里为了避免重复访问
        board[x][y] = '#';
        boolean flag = dfs(board, x + 1, y, word, start + 1)
                || dfs(board, x - 1, y, word, start + 1)
                || dfs(board, x, y + 1, word, start + 1)
                || dfs(board, x, y - 1, word, start + 1);
        board[x][y] = c;

        return flag;
    }
}
