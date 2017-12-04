package com.inuker.test;

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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class main {

    public static void main(String[] args) {

    }

    class Logger {

        HashMap<String, Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public Logger() {

        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            int time = map.getOrDefault(message, -100);
            if (time <= timestamp - 10) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
