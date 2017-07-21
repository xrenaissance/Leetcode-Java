package com.inuker.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/2.
 */

public class ClosestBinarySearchTreeValueII {

    // https://discuss.leetcode.com/topic/22940/ac-clean-java-solution-using-two-stacks/2
    // https://discuss.leetcode.com/topic/23151/o-logn-java-solution-with-two-stacks-following-hint

    // 耗时5ms，时间复杂度O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorderTraversal(root, list);

        int index = -1;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            double delta = Math.abs(list.get(i).val - target);
            if (delta < min) {
                min = delta;
                index = i;
            } else {
                break;
            }
        }

        List<Integer> result = new LinkedList<Integer>();
        result.add(list.get(index).val);

        for (int i = index - 1, j = index + 1; result.size() < k; ) {
            double delta1 = i >= 0 ? Math.abs(list.get(i).val - target) : Double.MAX_VALUE;
            double delta2 = j < list.size() ? Math.abs(list.get(j).val - target) : Double.MAX_VALUE;
            if (delta1 > delta2) {
                result.add(list.get(j++).val);
            } else {
                result.add(list.get(i--).val);
            }
        }

        return result;
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
    }
}
