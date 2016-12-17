package com.inuker.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;

        TrieNode root = new TrieNode();

        for (String word : words) {
            buildTrie(word, root);
        }

        List<String> result = new ArrayList<String>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];

        if (c < 'a' || c > 'z') {
            return;
        }

        node = node.next[c - 'a'];

        if (node == null) {
            return;
        }

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i, j + 1, node, result);
        dfs(board, i, j - 1, node, result);
        board[i][j] = '#';
    }

    private void buildTrie(String word, TrieNode root) {
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new TrieNode();
            }
            root = root.next[c - 'a'];
        }
        root.word = word;
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
