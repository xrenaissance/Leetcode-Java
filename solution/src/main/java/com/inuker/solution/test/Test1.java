package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeLinkNode;
import com.inuker.solution.TreeNode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import sun.tools.tree.InlineMethodExpression;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public abstract class Test1 {

    public class WordDictionary {

        Trie root = new Trie();

        // Adds a word into the data structure.
        public void addWord(String word) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new Trie();
                }
                node = node.nodes[c - 'a'];
            }
            node.word = word;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Trie trie, String word, int index) {
            if (trie == null) {
                return false;
            }
            if (index == word.length()) {
                return trie.word != null;
            }
            char c = word.charAt(index);
            if (c != '.') {
                return search(trie.nodes[c - 'a'], word, index + 1);
            } else {
                for (Trie node : trie.nodes) {
                    if (node != null) {
                        if (search(node, word, index + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

    private class Trie {
        Trie[] nodes = new Trie[26];
        String word;
    }

    abstract boolean knows(int a, int b);

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    abstract int read4(char[] buf);

    private static final String[] LESS20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] LESS100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private static final String[] THOUSAND = {
            "", "Thousand", "Million", "Billion"
    };

}
