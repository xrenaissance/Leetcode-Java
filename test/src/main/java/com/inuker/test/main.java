package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.Interval;
import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        Codec c = new Codec();
        String s = c.encode(Arrays.asList("hello", "how", "are", "you"));
        System.out.println(s);
        for (String ss : c.decode(s)) {
            System.out.println(ss);
        }
    }

    class ValidWordAbbr {

        HashMap<String, Set<String>> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String s : dictionary) {
                String abbr = getAbbr(s);
                Set<String> set = map.getOrDefault(abbr, new HashSet<String>());
                set.add(s);
                map.put(abbr, set);
            }
        }

        private String getAbbr(String s) {
            return s.length() > 2 ? s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1) : s;
        }

        public boolean isUnique(String word) {
            String abbr = getAbbr(word);
            if (!map.containsKey(abbr)) {
                return true;
            }
            Set<String> set = map.get(abbr);
            return set.size() == 1 && set.contains(word);
        }
    }
}
