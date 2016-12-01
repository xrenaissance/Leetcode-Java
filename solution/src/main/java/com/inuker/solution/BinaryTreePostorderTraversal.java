package com.inuker.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 16/12/1.
 */

public class BinaryTreePostorderTraversal {

    // 这里虽然最后的结果返回的是对的，但真正访问节点的顺序是不对的，root并不是最后访问的
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                results.add(0, root.val);
                root = root.right;
            } else {
                root = stack.pop().left;
            }
        }
        return results;
    }
}
