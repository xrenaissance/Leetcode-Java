package com.inuker.solution.test;

import com.inuker.solution.IntegerToEnglishWords;
import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;
import com.inuker.solution.TrieNode;

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

import javax.swing.plaf.basic.BasicScrollPaneUI;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.remove(beginWord);
        wordList.add(endWord);

        Queue<String> queue = new LinkedList<>();
        Queue<String> next = new LinkedList<>();
        queue.add(beginWord);

        int ladder = 1;

        while (!queue.isEmpty()) {
            String word = queue.poll();

            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if (j + 'a' == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) (j + 'a'));
                    String s = sb.toString();

                    if (s.equals(endWord)) {
                        return ladder + 1;
                    }

                    if (wordList.remove(s)) {
                        next.add(s);
                    }
                }
                sb.setCharAt(i, c);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                ladder++;
            }
        }

        return 0;
    }
}
