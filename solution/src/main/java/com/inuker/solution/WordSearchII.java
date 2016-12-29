package com.inuker.solution;

import com.inuker.solution.test.Test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by dingjikerbo on 16/11/22.
 */

public class WordSearchII {

    private class Trie {
        Trie[] nodes = new Trie[26];
        String word;
    }

    private void buildTrie(Trie trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (trie.nodes[word.charAt(i) - 'a'] == null) {
                trie.nodes[word.charAt(i) - 'a'] = new Trie();
            }
            trie = trie.nodes[word.charAt(i) - 'a'];
        }
        trie.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            buildTrie(trie, word);
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(set, board, i, j, trie);
            }
        }
        return new LinkedList<String>(set);
    }

    private void dfs(Set<String> set, char[][] board, int i, int j, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (trie == null) {
            return;
        }
        char c = board[i][j];
        if (c < 'a' || c > 'z') {
            return;
        }
        trie = trie.nodes[c - 'a'];
        if (trie == null) {
            return;
        }
        if (trie.word != null) {
            set.add(trie.word);
        }

        board[i][j] ^= '#';
        dfs(set, board, i + 1, j, trie);
        dfs(set, board, i - 1, j, trie);
        dfs(set, board, i, j + 1, trie);
        dfs(set, board, i, j - 1, trie);
        board[i][j] ^= '#';
    }
}
