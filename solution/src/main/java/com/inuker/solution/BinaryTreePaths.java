package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class BinaryTreePaths {

    // 耗时2ms
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        if (root == null) {
            return list;
        }
        traverse(root, list, String.valueOf(root.val));
        return list;
    }

    private void traverse(TreeNode node, List<String> list, String path) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(path);
            return;
        }

        if (node.left != null) {
            traverse(node.left, list, path + "->" + node.left.val);
        }

        if (node.right != null) {
            traverse(node.right, list, path + "->" + node.right.val);
        }
    }
}
