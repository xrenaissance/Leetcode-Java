package com.inuker.test;

import com.inuker.solution.BinaryTreeInorderTraversal;
import com.inuker.solution.ClosestBinarySearchTreeValueII;
import com.inuker.solution.InorderSuccessorInBST;
import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class main {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{
                2, 1
        });

        List<Integer> list = closestKValues(root, 4.14, 2);
        for (Integer n : list) {
            System.out.print(n + " ");
        }
    }

    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();

        for (TreeNode node = root; node != null; ) {
            if (target <= node.val) {
                postStack.push(node);
                node = node.left;
            } else {
                preStack.push(node);
                node = node.right;
            }
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (preStack.isEmpty()) {
                list.add(getNextSuccessor(postStack).val);
            } else if (postStack.isEmpty()) {
                list.add(getNextPredesessor(preStack).val);
            } else if (Math.abs(target - preStack.peek().val) < Math.abs(target - postStack.peek().val)) {
                list.add(getNextPredesessor(preStack).val);
            } else {
                list.add(getNextSuccessor(postStack).val);
            }
        }

        return list;
    }

    private static TreeNode getNextPredesessor(Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode ret = stack.pop();
        for (TreeNode node = ret.left; node != null; node = node.right) {
            stack.push(node);
        }
        return ret;
    }

    private static TreeNode getNextSuccessor(Stack<TreeNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        TreeNode ret = stack.pop();
        for (TreeNode node = ret.right; node != null; node = node.left) {
            stack.push(node);
        }
        return ret;
    }
}
