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
