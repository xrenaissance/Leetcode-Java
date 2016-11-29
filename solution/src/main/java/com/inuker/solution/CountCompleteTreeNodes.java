package com.inuker.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/29.
 */

public class CountCompleteTreeNodes {

    /** 适合通用的二叉树，但是对于完全二叉树会超时
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return count;
    }*/

    public int countNodes(TreeNode root) {

    }
}
