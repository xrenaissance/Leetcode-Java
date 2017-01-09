package com.inuker.solution.test;

import com.inuker.solution.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list, root.val + "");
        return list;
    }

    private void dfs(TreeNode root, List<String> list, String path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(path);
            return;
        }

        if (root.left != null) {
            dfs(root.left, list, path + "->" + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, list, path + "->" + root.right.val);
        }
    }
}
