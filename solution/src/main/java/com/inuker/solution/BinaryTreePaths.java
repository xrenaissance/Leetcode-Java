package com.inuker.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class BinaryTreePaths {
/**
    // 耗时31ms，性能不太好
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        if (root == null) {
            return list;
        }
        StringBuilder sb = new StringBuilder(String.format("%d", root.val));
        traverse(root, list, sb);
        return list;
    }

    private void traverse(TreeNode node, List<String> list, StringBuilder sb) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(sb.toString());
            return;
        }

        if (node.left != null) {
            int len = sb.length();
            sb.append(String.format("->%d", node.left.val));
            traverse(node.left, list, sb);
            sb.setLength(len);
        }

        if (node.right != null) {
            int len = sb.length();
            sb.append(String.format("->%d", node.right.val));
            traverse(node.right, list, sb);
            sb.setLength(len);
        }
    }
*/

/** 针对上面写法的改进，去掉String.format()，耗时降到了2ms
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        if (root == null) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        traverse(root, list, sb);
        return list;
    }

    private void traverse(TreeNode node, List<String> list, StringBuilder sb) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(sb.toString());
            return;
        }

        if (node.left != null) {
            int len = sb.length();
            sb.append("->").append(node.left.val);
            traverse(node.left, list, sb);
            sb.setLength(len);
        }

        if (node.right != null) {
            int len = sb.length();
            sb.append("->").append(node.right.val);
            traverse(node.right, list, sb);
            sb.setLength(len);
        }
    }
 */

    // 耗时2ms，不用StringBuilder，直接用字符串相加，这样写更简洁
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
