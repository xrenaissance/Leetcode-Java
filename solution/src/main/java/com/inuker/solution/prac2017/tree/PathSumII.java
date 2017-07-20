package com.inuker.solution.prac2017.tree;

import com.inuker.solution.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/7/20.
 */

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new LinkedList<>();
        list.add(root.val);

        pathSum(root, sum, result, list);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(list));
            return;
        }

        if (root.left != null) {
            list.add(root.left.val);
            pathSum(root.left, sum - root.val, result, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            list.add(root.right.val);
            pathSum(root.right, sum - root.val, result, list);
            list.remove(list.size() - 1);
        }
    }
}
