package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.PalindromeLinkedList;
import com.inuker.solution.TreeNode;

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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);

        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c - 'a'] != 0) {
                    indegree[c - 'a'] = 0;
                    count++;
                }
            }
        }

        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    Set<Character> set = map.get(first.charAt(j));
                    if (set == null) {
                        set = new HashSet<Character>();
                        map.put(first.charAt(j), set);
                    }
                    if (set.add(second.charAt(j))) {
                        indegree[second.charAt(j) - 'a']++;
                    }
                } else {
                    if (j + 1 >= second.length() && j + 1 < first.length()) {
                        return "";
                    }
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            Set<Character> set = map.get(c);
            if (set != null) {
                for (char cc : set) {
                    if (--indegree[cc - 'a'] == 0) {
                        queue.add(cc);
                    }
                }
            }
        }

        if (sb.length() != count) {
            return "";
        }

        return sb.toString();
    }
}
