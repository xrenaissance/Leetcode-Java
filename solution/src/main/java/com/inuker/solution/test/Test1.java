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

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public abstract class Test1 {



    public static class RandomizedCollection {

        HashMap<Integer, Set<Integer>> map;
        List<Integer> list;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<Integer, Set<Integer>>();
            list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean f = map.containsKey(val);
            Set<Integer> set = map.get(val);
            if(set == null) {
                set = new HashSet<Integer>();
                map.put(val, set);
            }
            list.add(val);
            set.add(list.size() - 1);
            return !f;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Set<Integer> set = map.get(val);
            if (set == null || set.isEmpty()) {
                return false;
            }
             int idx = set.iterator().next();
            if (idx != list.size() - 1) {
                int last = list.get(list.size() - 1);
                list.set(idx, last);
                Set<Integer> lastset = map.get(last);
                lastset.remove(list.size() - 1);
                lastset.add(idx);
            }
            list.remove(list.size() - 1);
            set.remove(idx);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

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
