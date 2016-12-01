package com.inuker.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/12/1.
 */

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
            }

            list.add(root.val);

            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                stack.push(root.left);
            }

            // 注意这里别掉了，否则会死循环
            root = null;
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                result.add(root.val);  // Add before going to children
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return result;
    }
}
