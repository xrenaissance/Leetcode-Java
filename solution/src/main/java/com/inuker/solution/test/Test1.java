package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;
import com.inuker.solution.TrieNode;
import com.inuker.solution.UndirectedGraphNode;
import com.inuker.solution.WordDictionary;
import com.inuker.solution.WordLadderII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    class WordNode {
        String word;
        WordNode prev;

        public WordNode(String word, WordNode pre) {
            this.word = word;
            this.prev = pre;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> next = new LinkedList<>();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, null));

        // 假如dict中有start则删掉
        wordList.remove(beginWord);
        wordList.add(endWord);

        HashSet<String> visited = new HashSet<String>();

        while (!queue.isEmpty()) {
            WordNode top = queue.poll();
            String word = top.word;

            if (word.equals(endWord)) {
                ArrayList<String> t = new ArrayList<String>();
                for (WordNode p = top; p != null; p = p.prev) {
                    t.add(0, p.word);
                }
                result.add(t);
                continue;
            }

            if (!result.isEmpty() && queue.isEmpty()) {
                break;
            }

            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if ('a' + j == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) ('a' + j));
                    String newWord = sb.toString();
                    if (wordList.contains(newWord)) {
                        next.add(new WordNode(newWord, top));
                        visited.add(newWord);
                    }
                }
                sb.setCharAt(i, c);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                wordList.removeAll(visited);
            }
        }

        return result;
    }
}
