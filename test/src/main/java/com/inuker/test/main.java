package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node5, node4);
        TreeNode node2 = new TreeNode(2, node3, null);


        List<Integer> list = new BinaryTreeInorderTraversal().inorderTraversal2(node2);
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> smaller = new Stack<>();
        Stack<Integer> larger = new Stack<>();
        helper(root, smaller, target, true);
        helper(root, larger, target, false);
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (smaller.isEmpty()) {
                result.add(larger.pop());
            } else if (larger.isEmpty()) {
                result.add(smaller.pop());
            } else if (Math.abs(smaller.peek() - target) < Math.abs(larger.peek() - target)) {
                result.add(smaller.pop());
            } else {
                result.add(larger.pop());
            }
        }
        return result;
    }

    private void helper(TreeNode root, Stack<Integer> stack0, double target, boolean smaller) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = smaller ? root.left : root.right;
            } else {
                root = stack.pop();

                if ((smaller && root.val >= target) || (!smaller && root.val < target)) {
                    return;
                }

                stack0.push(root.val);
                root = smaller ? root.right : root.left;
            }
        }
    }
}
