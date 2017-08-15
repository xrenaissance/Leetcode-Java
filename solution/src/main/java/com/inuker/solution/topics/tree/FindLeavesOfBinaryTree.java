package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwentian on 17/8/3.
 */

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        findLeaves(root, result);
        return result;
    }

    private int findLeaves(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }

        int left = findLeaves(root.left, res);
        int right = findLeaves(root.right, res);
        int level = Math.max(left, right) + 1;

        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        return level;
    }
}
