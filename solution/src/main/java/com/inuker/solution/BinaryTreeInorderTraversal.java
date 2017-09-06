package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/12/1.
 */

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
