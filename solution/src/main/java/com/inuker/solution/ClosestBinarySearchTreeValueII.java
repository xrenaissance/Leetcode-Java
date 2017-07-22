package com.inuker.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/2.
 */

/**
 * 有三种解法：
 * 1，中序完整遍历一遍二叉树形成一个list，再找到最接近target的node，然后依次往左右两边延伸到找满k个节点，复杂度O(n + lgn + k)
 * 2，中序遍历两遍二叉树，不过每次都会中途退出，构成双栈，一个是大于target，一个是小于target，然后依次出栈满k为止，复杂度O(n + k)
 * 3，中序完整遍历一遍二叉树，依次将节点加入优先级队列，按与target的差排序，选前k个，复杂度O(nlgk)
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


    /** 复杂度O(n + k)，双栈挺巧妙
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();

        inorderTraverse(preStack, root, target, false);
        inorderTraverse(postStack, root, target, true);

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (preStack.isEmpty()) {
                list.add(postStack.pop().val);
            } else if (postStack.isEmpty()) {
                list.add(preStack.pop().val);
            } else if (Math.abs(target - preStack.peek().val) < Math.abs(target - postStack.peek().val)) {
                list.add(preStack.pop().val);
            } else {
                list.add(postStack.pop().val);
            }
        }

        return list;
    }

    private void inorderTraverse(Stack<TreeNode> stack0, TreeNode root, double target, boolean reverse) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = reverse ? root.right : root.left;
            } else {
                TreeNode node = stack.pop();

                if ((reverse && node.val <= target) || (!reverse && node.val > target)) {
                    return;
                }

                stack0.push(node);
                root = reverse ? node.left : node.right;
            }
        }
    }*/
}
