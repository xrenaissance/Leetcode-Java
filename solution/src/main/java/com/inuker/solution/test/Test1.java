package com.inuker.solution.test;

import com.inuker.solution.Interval;
import com.inuker.solution.ListNode;
import com.inuker.solution.NestedInteger;
import com.inuker.solution.SumRootToLeafNumbers;
import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicScrollPaneUI;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

/**
 * Created by dingjikerbo on 2016/12/29.
 */

public class Test1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (parents.containsKey(p) && parents.containsKey(q)) {
                break;
            }

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

        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node = p; node != null; node = parents.get(node)) {
            set.add(node);
        }

        for (TreeNode node = q; node != null; node = parents.get(node)) {
            if (set.contains(node)) {
                return node;
            }
        }

        return null;
    }
}
