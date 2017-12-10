package com.inuker.test;

import com.inuker.solution.FindAllNumbersDisappearedInAnArray;
import com.inuker.solution.MinimumSizeSubarraySum;
import com.inuker.solution.NextPermutation;
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
        List<Integer> list = new test().countSmaller(new int[] {
                5, 2, 6, 1
        });
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }


    static class test {
        class Node {
            Node left, right;
            int val;

            /**
             * 左子树的节点个数
             */
            int sum;

            /**
             * 节点重复数
             */
            int dup = 1;

            public Node(int v, int s) {
                val = v;
                sum = s;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            Node root = null;
            Integer[] res = new Integer[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                root = insert(root, nums[i], 0, res, i);
            }
            return Arrays.asList(res);
        }

        private Node insert(Node root, int n, int pre, Integer[] res, int i) {
            if (root == null) {
                root = new Node(n, 0);
                res[i] = pre;
            } else if (root.val == n) {
                root.dup++;
                res[i] = pre + root.sum;
            } else if (n < root.val) {
                root.sum++;
                root.left = insert(root.left, n, pre, res, i);
            } else {
                root.right = insert(root.right, n, pre + root.sum + root.dup, res, i);
            }
            return root;
        }
    }


}
