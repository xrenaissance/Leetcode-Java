package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.inuker.solution.WiggleSortII;
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
        int[] arr = new int[] {
                6, 13, 5, 4, 5, 2
        };
        int ff = new fd().findKthLargest(arr, 6);
        System.out.println(ff);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return node;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode right = node.right;
        TreeNode leftTail = helper(node.left);
        TreeNode rightTail = helper(node.right);
        if (leftTail != null) {
            node.right = node.left;
            leftTail.right = right;
            node.left = null;
        }
        return rightTail != null ? rightTail : leftTail;
    }
}
