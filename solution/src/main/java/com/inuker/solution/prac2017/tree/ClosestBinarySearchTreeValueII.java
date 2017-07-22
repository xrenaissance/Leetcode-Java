package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2017/7/22.
 */

public class ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();

        inorderTraverse(preStack, root, target, false);
        inorderTraverse(postStack, root, target, true);

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (preStack.isEmpty()) {
                list.add(postStack.pop().val);
            } else if (postStack.isEmpty()) {
                list.add(preStack.pop().val);
            } else if (Math.abs(target - preStack.peek().val) < Math.abs(target - postStack.peek().val)) {
                list.add(preStack.pop().val);
            } else {
                list.add(postStack.pop().val);
            }
        }

        return list;
    }

    private void inorderTraverse(Stack<TreeNode> stack0, TreeNode root, double target, boolean reverse) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = reverse ? root.right : root.left;
            } else {
                TreeNode node = stack.pop();

                if ((reverse && node.val <= target) || (!reverse && node.val > target)) {
                    return;
                }

                stack0.push(node);
                root = reverse ? node.left : node.right;
            }
        }
    }
}
