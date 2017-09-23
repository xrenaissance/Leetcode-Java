package com.leetcode.topics.tree;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/7/20.
 */

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        pathSum(root, sum, result, new LinkedList<Integer>());
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(list));
            return;
        }

        if (root.left != null) {
            pathSum(root.left, sum - root.val, result, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            pathSum(root.right, sum - root.val, result, list);
            list.remove(list.size() - 1);
        }
    }
}
