package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liwentian on 17/7/16.
 */

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();

        List<TreeNode> list = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }
}
