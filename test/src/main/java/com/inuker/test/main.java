package com.inuker.test;

import com.inuker.solution.SearchForARange;
import com.leetcode.library.ListNode;
import com.leetcode.library.RandomListNode;
import com.leetcode.library.TreeNode;
import com.leetcode.library.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        System.out.println(multiply("99", "100"));
    }

    public static String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int n = result[i + j + 1] + n1 * n2;
                result[i + j + 1] = n % 10;
                result[i + j] += n / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 || sb.length() > 0) {
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
