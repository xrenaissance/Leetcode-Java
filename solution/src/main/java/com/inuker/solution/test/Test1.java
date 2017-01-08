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
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (parents.containsKey(p) && parents.containsKey(q)) {
                break;
            }

            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                parents.put(node.left, node);
            }

            if (node.right != null) {
                queue.add(node.right);
                parents.put(node.right, node);
            }
        }

        if (!parents.containsKey(p) || !parents.containsKey(q)) {
            return null;
        }

        Set<TreeNode> set = new HashSet<TreeNode>();
        for (TreeNode node = p; node != null; node = parents.get(node)) {
            set.add(node);
        }

        for (TreeNode node = q; node != null; node = parents.get(node)) {
            if (!set.add(node)) {
                return node;
            }
        }

        return null;
    }

    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return getCommonLength(str + rev, str.length());
    }

    private int getCommonLength(String s, int max) {
        for (int i = s.length() - max; i < s.length(); i++) {
            if (s.startsWith(s.substring(i))) {
                return s.length() - i;
            }
        }
        return 0;
    }
}
