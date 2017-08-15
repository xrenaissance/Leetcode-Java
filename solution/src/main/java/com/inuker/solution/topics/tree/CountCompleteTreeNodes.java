package com.inuker.solution.topics.tree;

import com.inuker.solution.TreeNode;

/**
 * Created by liwentian on 17/7/17.
 */

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int left = 0, right = 0;
        for (TreeNode node = root; node != null; node = node.left) {
            left++;
        }
        for (TreeNode node = root; node != null; node = node.right) {
            right++;
        }
        if (left == right) {
            return (1 << left) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
