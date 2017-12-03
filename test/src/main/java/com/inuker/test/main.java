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
    }

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (String line : input.split("\n")) {
            int depth = line.lastIndexOf("\t") + 1;
            while (stack.size() > depth) {
                stack.pop();
            }
            int parentLen = stack.isEmpty() ? 0 : stack.peek();
            int len = parentLen + line.length() - depth;
            if (line.contains(".")) {
                max = Math.max(len, max);
            } else {
                stack.push(len + 1);
            }
        }
        return max;
    }
}
