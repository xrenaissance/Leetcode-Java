package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2017/7/19.
 */

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                list.add(0, root.val);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }
        return list;
    }
}
