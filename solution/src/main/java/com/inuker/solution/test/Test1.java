package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    class Node {
        String word;
        Node prev;
        int dis;

        Node(String word, Node prev, int dis) {
            this.word = word;
            this.prev = prev;
            this.dis = dis;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, null, 1));
        wordList.add(endWord);
        wordList.remove(beginWord);
        List<List<String>> result = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        int minDis = -1, curDis = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.word.equals(endWord)) {
                if (minDis == -1) {
                    minDis = node.dis;
                }
                List<String> t = new LinkedList<>();
                for (Node p = node; p != null; p = p.prev) {
                    t.add(0, p.word);
                }
                result.add(t);
                continue;
            }

            if (node.dis != curDis) {
                curDis = node.dis;
                wordList.removeAll(visited);
            }

            if (minDis != -1 && node.dis > minDis) {
                break;
            }

            if (wordList.isEmpty()) {
                continue;
            }

            StringBuilder sb = new StringBuilder(node.word);
            for (int i = 0; i < node.word.length(); i++) {
                char c = sb.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if (j + 'a' == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) (j + 'a'));
                    String t = sb.toString();
                    if (wordList.contains(t)) {
                        queue.add(new Node(t, node, node.dis + 1));
                        visited.add(t);
                    }
                }
                sb.setCharAt(i, c);
            }
        }
        return result;
    }

     boolean knows(int a, int b) {
        return false;
     }

    private final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

     int read4(char[] buf) {
         return 0;
     }

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
