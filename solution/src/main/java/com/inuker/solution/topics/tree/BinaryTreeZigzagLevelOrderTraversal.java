package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liwentian on 17/7/20.
 */

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        int level = 0;

        List<Integer> list = null;

        if (root == null) {
            return result;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (list == null) {
                list = new LinkedList<>();
                level++;
            }

            if ((level & 1) != 0) {
                list.add(node.val);
            } else {
                list.add(0, node.val);
            }

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                result.add(list);
                next.clear();;
                list = null;
            }
        }

        return result;
    }
}
