package com.inuker.solution.tree;

import com.inuker.solution.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2017/7/19.
 */

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        queue.add(root);

        List<Integer> level = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            level.add(node.val);

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (queue.isEmpty()) {
                result.add(0, level);
                level = new LinkedList<>();

                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }
}
