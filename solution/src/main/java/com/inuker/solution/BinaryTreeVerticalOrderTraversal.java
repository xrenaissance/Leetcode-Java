package com.inuker.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dingjikerbo on 2016/11/19.
 */

public class BinaryTreeVerticalOrderTraversal {

    private int minKey = 0, maxKey = 0;

    // 耗时6ms
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }

        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<Integer, List<Integer>>();

        map.put(root, 0);
        map2.put(0, new LinkedList<Integer>(Arrays.asList(root.val)));

        traverse(root, map, map2);

        for (int i = minKey; i <= maxKey; i++) {
            if (map2.containsKey(i)) {
                result.add(map2.get(i));
            }
        }

        return result;
    }

    private void traverse(TreeNode root, HashMap<TreeNode, Integer> map, HashMap<Integer, List<Integer>> map2) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int index = map.get(node);

            if (node.left != null) {
                saveNodeIndex(node.left, index - 1, map, map2);
                queue.add(node.left);
            }

            if (node.right != null) {
                saveNodeIndex(node.right, index + 1, map, map2);
                queue.add(node.right);
            }
        }
    }

    private void saveNodeIndex(TreeNode node, int index, HashMap<TreeNode, Integer> map, HashMap<Integer, List<Integer>> map2) {
        map.put(node, index);
        List<Integer> list = map2.get(index);
        if (list == null) {
            list = new LinkedList<Integer>();
            map2.put(index, list);
        }
        minKey = Math.min(minKey, index);
        maxKey = Math.max(maxKey, index);
        list.add(node.val);
    }
}
