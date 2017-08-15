package com.inuker.solution.tree;

import com.inuker.solution.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liwentian on 17/7/14.
 */

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Queue<TreeNode> next = new LinkedList<>();

        List<Integer> list = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (list == null) {
                list = new LinkedList<>();
            }

            list.add(node.val);

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                result.add(list);
                list = null;
                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }
}
