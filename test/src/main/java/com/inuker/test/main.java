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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        String s = decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }

    public static String decodeString(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.append(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.charAt(stack.length() - 1) != '[') {
                    sb.insert(0, stack.charAt(stack.length() - 1));
                    stack.setLength(stack.length() - 1);
                }
                stack.setLength(stack.length() - 1);
                int n = 0, t = 1;
                while (stack.length() > 0 && Character.isDigit(stack.charAt(stack.length() - 1))) {
                    n += t * (stack.charAt(stack.length() - 1) - '0');
                    t *= 10;
                    stack.setLength(stack.length() - 1);
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < sb.length(); j++) {
                        stack.append(sb.charAt(j));
                    }
                }
            }
        }
        return stack.toString();
    }
}
