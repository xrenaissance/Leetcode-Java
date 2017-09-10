package com.inuker.solution;

import com.leetcode.library.TreeNode;

import java.util.HashSet;

/**
 * Created by liwentian on 2017/9/10.
 */

/**
 * https://leetcode.com/articles/two-sum-iv/
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode node, HashSet<Integer> set, int k) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }
}
