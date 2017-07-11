package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

import java.util.Stack;

/**
 * Created by liwentian on 17/7/11.
 */

public class BSTIterator {

    private TreeNode node;

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        for (node = root; node != null; node = node.left) {
            stack.push(node);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (node == null) {
            node = stack.pop();
        }

        int val = node.val;

        for (node = node.right; node != null; node = node.left) {
            stack.push(node);
        }

        return val;
    }
}
