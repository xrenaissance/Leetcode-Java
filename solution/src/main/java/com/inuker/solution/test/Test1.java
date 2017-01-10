package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public static class WordDictionary {

        class Trie {
            Trie[] nodes = new Trie[26];
            String word;
        }

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

        private boolean search(Trie trie, String word, int start) {
            if (trie == null) {
                return false;
            }
            if (start == word.length()) {
                /**
                 * 这个返回的条件一定要注意，不是trie.word.equals(word)
                 */
                return trie.word != null;
            }
            char c = word.charAt(start);
            if (c != '.') {
                return search(trie.nodes[c - 'a'], word, start + 1);
            } else {
                for (Trie trie0 : trie.nodes) {
                    if (trie0 != null && search(trie0, word, start + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
