package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/7/15.
 */

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list, "");
        return list;
    }

    private void dfs(TreeNode root, List<String> result, String s) {
        if (root == null) {
            return;
        }

        s += (s.isEmpty() ? "" : "->") + root.val;

        if (root.left == null && root.right == null) {
            result.add(s);
            return;
        }

        dfs(root.left, result, s);
        dfs(root.right, result, s);
    }
}
