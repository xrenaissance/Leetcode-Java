package com.inuker.solution.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return getCommonLength(str + rev, str.length());
    }

    private int getCommonLength(String s, int max) {
        for (int i = s.length() - max; i < s.length(); i++) {
            if (s.startsWith(s.substring(i))) {
                return s.length() - i;
            }
        }
        return 0;
    }
}
